package com.formations.ebank.utils;


import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.OperationDto;
import com.formations.ebank.dtos.ProfileDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Compte;
import com.formations.ebank.entities.Profile;
import com.formations.ebank.entities.Utilisateur;
import com.formations.ebank.enums.EnumStatusCompte;
import com.formations.ebank.enums.EnumTypeOperation;
import com.formations.ebank.enums.EnumTypeProfile;
import com.formations.ebank.repositories.*;
import com.formations.ebank.security.MailSenderService;
import com.formations.ebank.security.SecurityManagerService;
import com.formations.ebank.services.ICompteService;
import com.formations.ebank.services.IOperationService;
import com.formations.ebank.services.IUtilisateurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class Test {

    private final IUtilisateurService iUtilisateurService;
    private final ProfileJpaRepo profileJpaRepo;
    private final CustomModelMapper customModelMapper;
    private final UtilisateurJpaRepo utilisateurJpaRepo;
    private final CompteJpaRepo compteJpaRepo;
    private final ICompteService iCompteService;
    private final OperationJpaRepo operationJpaRepo;
    private final UtilisateurProfileJpaRepo utilisateurProfileJpaRepo;
    private final SecurityManagerService securityManagerService;
    private final MailSenderService mailService;
    private final IOperationService iOperationService;
    @Bean
    CommandLineRunner commandLineRunner() {


        return args -> {


           /*var clientProfileTosave =profileJpaRepo.findById(3);
            ProfileDto profileDto=customModelMapper.modelMapper()
                    .map(clientProfileTosave,ProfileDto.class);
            iUtilisateurService.affecterProfile(1,profileDto);*/

            /*var utilisateurDtoImaneCompte=iUtilisateurService.chercherUtilisateurParId(2);


            CompteDto compteDtoImane = CompteDto.builder().id(null).statusCompte(EnumStatusCompte.OUVERT)
                    .utilisateurDto(utilisateurDtoImaneCompte).solde(3000d).rib("123256789123556789123456789")
                    .build();

            this.iCompteService.nouveauCompte(compteDtoImane);*/
            var utilisateurDtoCompteMohamed=iUtilisateurService.chercherUtilisateurParId(1);


          /*  CompteDto compteDtoMohamed = CompteDto.builder().id(null).statusCompte(EnumStatusCompte.OUVERT)
                    .utilisateurDto(utilisateurDtoCompteMohamed).solde(0d).rib("323256789123556789123456789")
                    .build();

            this.iCompteService.nouveauCompte(compteDtoMohamed);*/


            //Test operation
          /*  UtilisateurDto utilisateurDtoCompteOperation =
                    iUtilisateurService.chercherUtilisateurParId(1);
            Double montant = 1000d;
            String rib = "323256789123556789123456789";
            EnumTypeOperation operationDebit = EnumTypeOperation.DEBIT;
            Optional<OperationDto>operationDto=iOperationService.nouveauOperation(null,
                    rib,montant,operationDebit,utilisateurDtoCompteOperation,null
            );

*/
            /*UtilisateurDto utilisateurDtoCompteImaneOperationCrediteur =
                    iUtilisateurService.chercherUtilisateurParId(2);
            Double montant = 1000d;
            String ribCrediteur = "223256789123556789123456789";
            String ribDestinateur="323256789123556789123456789";
            EnumTypeOperation operationVirement = EnumTypeOperation.VIRMENT;
            iOperationService.nouveauOperation(ribDestinateur,
                    ribCrediteur,montant,operationVirement,
                    utilisateurDtoCompteImaneOperationCrediteur,
                    "Virement en faveur de "+utilisateurDtoCompteImaneOperationCrediteur.getNom()
            );



*/
           /* UtilisateurDto utilisateurDtoCompteImaneOperationCrediteur =
                    iUtilisateurService.chercherUtilisateurParId(2);
            Double montant = 1000d;
            String ribCrediteur = "223256789123556789123456789";
            String ribDestinateur="323256789123556789123456789";
            EnumTypeOperation operationVirement = EnumTypeOperation.VIRMENT;
            iOperationService.nouveauOperation(ribDestinateur,
                    ribCrediteur,montant,operationVirement,
                    utilisateurDtoCompteImaneOperationCrediteur,
                    "Virement en faveur de "+utilisateurDtoCompteImaneOperationCrediteur.getNom()
            );
*/
        };
    }
}
