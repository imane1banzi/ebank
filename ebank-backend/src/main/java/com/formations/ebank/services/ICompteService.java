package com.formations.ebank.services;

import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Compte;
import com.formations.ebank.entities.Utilisateur;

import java.util.List;

public interface ICompteService {

    CompteDto nouveauCompte(CompteDto compteDto);
    List<CompteDto> listeCompte();
    List<CompteDto> listeCompteByUtilisateur(UtilisateurDto utilisateurDto);
    void attacheCompteToUtilisateur(UtilisateurDto utilisateurDto,CompteDto compteDto);
    CompteDto chercherCompteParRib(String rib);

}
