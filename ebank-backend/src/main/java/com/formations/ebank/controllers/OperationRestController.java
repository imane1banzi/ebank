package com.formations.ebank.controllers;

import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.OperationDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.enums.EnumTypeOperation;
import com.formations.ebank.exceptions.CompteException;
import com.formations.ebank.exceptions.VirmentOperationException;
import com.formations.ebank.services.IOperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/bank")
public class OperationRestController {
    private final IOperationService iOperationService;

    public OperationRestController(IOperationService iOperationService) {
        this.iOperationService = iOperationService;
    }
    @PostMapping("/Operations")
    List<OperationDto> listeOperationParUtilisateur(@RequestParam(name = "utilisateurId") UtilisateurDto utilisateurId){
        return iOperationService.listeOperationParUtilisateur(utilisateurId);
    }
    @PostMapping("/nouvelleoperation")
    void nouveauOperation (String ribDestinatire, String rib,
                           Double montant, EnumTypeOperation typeOperation,
                           UtilisateurDto utilisateurDto,
                           String motifOperation)throws VirmentOperationException, CompteException{
        iOperationService.nouveauOperation(ribDestinatire,rib,montant,typeOperation,utilisateurDto,motifOperation);
    }
}
