package com.formations.ebank.dtos;

import com.formations.ebank.enums.EnumTypeOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDto {

    private Integer id;
    private EnumTypeOperation typeOperation;
    private UtilisateurDto intituleDto;
    private Double montant;
    private Date dateRealisation;

}
