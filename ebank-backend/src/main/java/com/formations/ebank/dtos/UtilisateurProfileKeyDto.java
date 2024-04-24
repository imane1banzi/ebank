package com.formations.ebank.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class UtilisateurProfileKeyDto implements Serializable {


     private Integer utilisateurId;

     private Integer profileId;


}
