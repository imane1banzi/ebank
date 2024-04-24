package com.formations.ebank.dtos;


import com.formations.ebank.entities.Profile;
import com.formations.ebank.entities.Utilisateur;
import com.formations.ebank.entities.UtilisateurProfileKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

 @Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurProfileDto implements Serializable {


    private Date crerationDate;

     private UtilisateurProfileKey utilisateurProfileKey;

       private UtilisateurDto utilisateur;


     private ProfileDto profile;


}
