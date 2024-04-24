package com.formations.ebank.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurProfile implements Serializable {


    private Date crerationDate;

    @EmbeddedId
    private UtilisateurProfileKey utilisateurProfileKey;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("utilisateur_id")
    @JoinColumn(name = "utilisateur_id",referencedColumnName = "id")
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("profile_id")
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private Profile profile;


}
