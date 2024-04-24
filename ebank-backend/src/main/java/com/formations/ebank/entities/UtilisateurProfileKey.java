package com.formations.ebank.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurProfileKey implements Serializable {


    @Column(name = "utilisateur_id")
    private Integer utilisateurId;

    @Column(name = "profile_id")
    private Integer profileId;


}
