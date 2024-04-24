package com.formations.ebank.services;

import com.formations.ebank.dtos.ProfileDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Profile;
import com.formations.ebank.entities.Utilisateur;

import java.util.List;

public interface IProfileService {

    List<ProfileDto> listProfile();
    List<ProfileDto> listProfileParUtilisateur(UtilisateurDto utilisateurDto);
    ProfileDto creerProfile(ProfileDto profileDto);

}
