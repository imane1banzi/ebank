package com.formations.ebank.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurDto {


    private Integer id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String passwordValidation;
    private Date dateAnniversaire;
    private String adresseMail;
    private String adressePostale;
    private String numeroIdentite;
    private List<UtilisateurProfileDto> ListUtilisateurProfileDto=Collections.emptyList();
    private List<CompteDto> compteDtoLists =Collections.emptyList();
    private List<OperationDto> operationDtoList= Collections.emptyList();
}
