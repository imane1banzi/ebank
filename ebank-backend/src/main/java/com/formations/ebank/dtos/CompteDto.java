package com.formations.ebank.dtos;

import com.formations.ebank.enums.EnumStatusCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompteDto {

    private Integer id;
    private EnumStatusCompte statusCompte;
    private  Double solde;
    private  String rib;
    private UtilisateurDto utilisateurDto;

}
