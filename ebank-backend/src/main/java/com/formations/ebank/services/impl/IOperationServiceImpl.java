package com.formations.ebank.services.impl;

import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.OperationDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Operation;
import com.formations.ebank.entities.Utilisateur;
import com.formations.ebank.enums.EnumStatusCompte;
import com.formations.ebank.enums.EnumTypeOperation;
import com.formations.ebank.exceptions.CompteException;
import com.formations.ebank.exceptions.VirmentOperationException;
import com.formations.ebank.repositories.OperationJpaRepo;
import com.formations.ebank.services.ICompteService;
import com.formations.ebank.services.IOperationService;
import com.formations.ebank.utils.CustomModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class IOperationServiceImpl implements IOperationService {


    private final OperationJpaRepo operationJpaRepo;
    private final ICompteService iCompteService;
    private final CustomModelMapper customModelMapper;

    public IOperationServiceImpl(OperationJpaRepo operationJpaRepo, ICompteService iCompteService, CustomModelMapper customModelMapper) {
        this.operationJpaRepo = operationJpaRepo;
        this.iCompteService = iCompteService;
        this.customModelMapper = customModelMapper;
    }

    @Override
    public void nouveauOperation(String ribDestinatire,
                                 String ribCrediteur,
                                 Double montant,
                                 EnumTypeOperation typeOperation,
                                 UtilisateurDto utilisateurDto,
                                 String motifOperation) throws VirmentOperationException,
            CompteException{
        Operation operation = new Operation();
        CompteDto compteDto = null;
        switch (typeOperation) {
            case DEBIT -> {
                operation.setTypeOperation(typeOperation);
                compteDto = this.debitOperation(montant, ribCrediteur);
                operation.setMotif(motifOperation);
                operation.setMontant(montant);
                operation.setUtilisateur(customModelMapper.modelMapper().map(utilisateurDto, Utilisateur.class));
                operation.setDateRealisation(new Date());

                iCompteService.nouveauCompte(compteDto);
                this.operationJpaRepo.save(operation);

            }
            case CREDIT -> {
                operation.setTypeOperation(typeOperation);
                compteDto = this.creditOperation(montant, ribCrediteur);
                operation.setMotif(motifOperation);
                operation.setMontant(montant);
                operation.setUtilisateur(customModelMapper.modelMapper().map(utilisateurDto, Utilisateur.class));
                operation.setDateRealisation(new Date());

                iCompteService.nouveauCompte(compteDto);
                this.operationJpaRepo.save(operation);

            }
            case VIRMENT -> {
                if (ribDestinatire != null) {
                    //check balance uppermore than montant source
                    CompteDto compteDtoCrediteur = iCompteService.chercherCompteParRib(ribCrediteur);
                    if (compteDtoCrediteur != null  &&
                            !(compteDtoCrediteur.getStatusCompte()
                                    .equals(EnumStatusCompte.CLOUTURE) ||
                                    compteDtoCrediteur.getStatusCompte()
                                            .equals(EnumStatusCompte.BLOQUE) )){
                        Double montantCrediteur = compteDtoCrediteur.getSolde();
                        if (montantCrediteur >= montant) {
                            //Crediteur
                            Operation operationCreditVirement = new Operation();
                            operationCreditVirement.setTypeOperation(typeOperation);
                           CompteDto compteDtoCredit=  this.creditOperation(montant, ribCrediteur);
                            operationCreditVirement.setMotif(motifOperation);
                            operationCreditVirement.setMontant(montant);
                            operationCreditVirement.setUtilisateur(customModelMapper.
                                    modelMapper().map(utilisateurDto, Utilisateur.class));
                            operationCreditVirement.setDateRealisation(new Date());
                            iCompteService.nouveauCompte(compteDtoCredit);
                            this.operationJpaRepo.save(operationCreditVirement);
                            //Debiteur
                            Operation operationDebitVirement = new Operation();
                            operationDebitVirement.setTypeOperation(typeOperation);
                            CompteDto compteDtoDebitVirment = this.debitOperation(montant, ribDestinatire);
                            UtilisateurDto utilisateurDtoDebiteurVirement=compteDtoDebitVirment.getUtilisateurDto();
                            operationDebitVirement.setMotif(motifOperation);
                            operationDebitVirement.setMontant(montant);
                            operationDebitVirement.setUtilisateur(customModelMapper.modelMapper().
                                    map(utilisateurDtoDebiteurVirement, Utilisateur.class));
                            operationDebitVirement.setDateRealisation(new Date());
                            iCompteService.nouveauCompte(compteDtoDebitVirment);
                            this.operationJpaRepo.save(operationDebitVirement);

                        } else
                            throw new CompteException("Montant inssufisant");
                    }else
                        throw new VirmentOperationException("Compte bloqué ou clotûré");
                }else
                    throw new CompteException("RIB non existe");

            }

        }

    }

    @Override
    public List<OperationDto> listeOperationParUtilisateur(UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public CompteDto debitOperation(Double montant, String rib) {
        CompteDto compteDtoToDebit = iCompteService.chercherCompteParRib(rib);
        compteDtoToDebit.setSolde(compteDtoToDebit.getSolde() + montant);


        return compteDtoToDebit;
    }

    @Override
    public CompteDto creditOperation(Double montant, String rib) {
        CompteDto compteDtoToCredit = iCompteService.chercherCompteParRib(rib);
        if(compteDtoToCredit.getSolde()  >= montant)
        compteDtoToCredit.setSolde(compteDtoToCredit.getSolde() - montant);

        return compteDtoToCredit;
    }

    @Override
    public void nouveauVirement(String ribCrediteur, String ribDestinataire, String motif, Double montant, UtilisateurDto utilisateurDto) {
        //check balance upper than montant source
        CompteDto compteDtoCrediteur = iCompteService.chercherCompteParRib(ribCrediteur);
        if (compteDtoCrediteur != null) {
            Double montantCrediteur = compteDtoCrediteur.getSolde();
            if (montantCrediteur >= montant) {
            }
        }
        //Debiteur distinataire

        //Crediteur source
    }


}
