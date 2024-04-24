package com.formations.ebank.services;

import com.formations.ebank.dtos.ProfileDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Profile;
import com.formations.ebank.exceptions.UtilisateurCreationException;
import com.formations.ebank.exceptions.UtilisateurCredentialsException;

import java.util.Optional;

public interface IUtilisateurService {
    Optional<UtilisateurDto> seConnecter(String login, String password) throws UtilisateurCredentialsException;
    UtilisateurDto creerClient(UtilisateurDto client) throws UtilisateurCreationException;
    Boolean changePassword(String ancienPassword, String nouveauPassword);
    Boolean verifierAccesFonctionnaliteAuhtenticite(UtilisateurDto utilisateurDto);
    Boolean verifierAccesFonctionnaliteParAuthorite(UtilisateurDto utilisateurDto);
    void affecterProfile(Integer id, ProfileDto profileDto);
    String genereMotDePasseAuto();
    String genereLoginAuto();
    UtilisateurDto chercherUtilisateurParId(Integer id);

}
