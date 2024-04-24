package com.formations.ebank.services;

import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.OperationDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Operation;
import com.formations.ebank.entities.Utilisateur;
import com.formations.ebank.enums.EnumTypeOperation;
import com.formations.ebank.exceptions.CompteException;
import com.formations.ebank.exceptions.VirmentOperationException;

import java.util.List;
import java.util.Optional;

public interface IOperationService {
    void nouveauOperation(String ribDestinatire,String rib,
                          Double montant,EnumTypeOperation typeOperation,
                                            UtilisateurDto utilisateurDto,
                          String motifOperation) throws VirmentOperationException, CompteException;
    List<OperationDto> listeOperationParUtilisateur(UtilisateurDto utilisateurDto);
    CompteDto debitOperation(Double montant, String rib);
    CompteDto creditOperation(Double montant, String rib);
    void nouveauVirement(String ribCrediteur, String ribDestinataire,
                         String motif,Double montant,UtilisateurDto  utilisateurDto);
}
