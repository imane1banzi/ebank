package com.formations.ebank.services.impl;

import com.formations.ebank.dtos.ProfileDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Profile;
import com.formations.ebank.entities.Utilisateur;
import com.formations.ebank.entities.UtilisateurProfile;
import com.formations.ebank.entities.UtilisateurProfileKey;
import com.formations.ebank.enums.EnumSecurity;
import com.formations.ebank.exceptions.UtilisateurCreationException;
import com.formations.ebank.exceptions.UtilisateurCredentialsException;
import com.formations.ebank.repositories.UtilisateurJpaRepo;
import com.formations.ebank.repositories.UtilisateurProfileJpaRepo;
import com.formations.ebank.security.SecurityManagerService;
import com.formations.ebank.services.IUtilisateurService;
import com.formations.ebank.utils.CustomModelMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class IUtilisateurServiceImpl implements IUtilisateurService {

    private final UtilisateurJpaRepo utilisateurJpaRepo;
    private final SecurityManagerService securityManagerService;
    private final CustomModelMapper customModelMapper;
    private final UtilisateurProfileJpaRepo utilisateurProfileJpaRepo;

    @Override
    public Optional<UtilisateurDto> seConnecter(String login, String password)
            throws UtilisateurCredentialsException {
       /* log.info("Entred login : "+login+"; password : "+password);
        String decryptMotDPasse =securityManagerService
                .crypterMotDePasse(password,"");
        log.info("EncodedMotDPasse  password:  "+encodedMotDPasse);*/
        var optionalBoUtilisateurConnecte = utilisateurJpaRepo.
                findByLogin(login);
        if (optionalBoUtilisateurConnecte.isPresent()) {
            String decryptedPassword = securityManagerService.
                    decrypterMotDePasse(
                            optionalBoUtilisateurConnecte.get().getPassword(),
                            EnumSecurity.SecretKey.toString());
            System.out.println("decryptedPassword = " + decryptedPassword);
            if (decryptedPassword != null && decryptedPassword.equals(password)) {
                Utilisateur utilisateurConnecte = optionalBoUtilisateurConnecte.get();
                log.info("UserDTOConnected : ", utilisateurConnecte);
                UtilisateurDto utilisateurDto = customModelMapper
                        .modelMapper().map(utilisateurConnecte, UtilisateurDto.class);
                return Optional.of(utilisateurDto);
            } else
                throw new UtilisateurCredentialsException("Login ou mot de passe erronés ");
        } else
            return Optional.empty();


    }

    @Override
    public UtilisateurDto creerClient(UtilisateurDto client) throws UtilisateurCreationException {

        var utilisateurBo = customModelMapper
                .modelMapper().map(client, Utilisateur.class);
        utilisateurBo.setPassword(securityManagerService.
                crypterMotDePasse(utilisateurBo.getPassword()
                        , EnumSecurity.SecretKey.toString()));
        UtilisateurDto utilisateurDto = customModelMapper.modelMapper().
                map(this.utilisateurJpaRepo.save(utilisateurBo), UtilisateurDto.class);
        if (utilisateurDto != null) {
            return utilisateurDto;
        } else throw new UtilisateurCreationException("Cannot create utilisateur");
    }


    @Override
    public Boolean changePassword(String ancienPassword, String nouveauPassword) {
        return null;
    }

    @Override
    public Boolean verifierAccesFonctionnaliteAuhtenticite(UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public Boolean verifierAccesFonctionnaliteParAuthorite(UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public void affecterProfile(Integer id, ProfileDto profileDto) {
        Optional<Utilisateur> utilisateur = utilisateurJpaRepo.findById(id);
        if (utilisateur.isPresent()) {
            Utilisateur utilisateurBo = utilisateur.get();


            utilisateurJpaRepo.save(utilisateurBo);
            //create key utilisateurProfileKey
            UtilisateurProfileKey
                    utilisateurProfileKey = UtilisateurProfileKey.
                    builder()
                    .profileId(profileDto.getId())
                    .utilisateurId(utilisateurBo
                            .getId()).build();
            var utilisateurProfile = UtilisateurProfile
                    .builder()
                    .profile(customModelMapper
                            .modelMapper()
                            .map(profileDto, Profile.class))
                    .utilisateur(utilisateurBo)
                    .utilisateurProfileKey(utilisateurProfileKey).build();
            utilisateurProfileJpaRepo.save(utilisateurProfile);

        }
    }

    @Override
    public String genereMotDePasseAuto() {
        try {

            return "";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String genereLoginAuto() {
        return null;
    }

    @Override
    public UtilisateurDto chercherUtilisateurParId(Integer id) {
         Optional<Utilisateur> optionalUtilisateur=this.utilisateurJpaRepo.findById(id);
         if (optionalUtilisateur.isPresent())
         {
             Utilisateur utilisateurBo=optionalUtilisateur.get();
             return  customModelMapper.modelMapper().map(utilisateurBo,UtilisateurDto.class);
         }
         return null;
    }
}
