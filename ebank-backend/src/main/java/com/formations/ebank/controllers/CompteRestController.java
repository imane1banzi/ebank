package com.formations.ebank.controllers;

import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.services.ICompteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/bank")
public class CompteRestController {
    private final ICompteService iCompteService;

    public CompteRestController(ICompteService iCompteService) {
        this.iCompteService = iCompteService;
    }
    @GetMapping("/Comptes")
    List<CompteDto> comptelist(){
        return iCompteService.listeCompte();
    }
    @PostMapping("/nouveauCompte")
    public ResponseEntity<CompteDto> addcompte(@Valid @RequestBody CompteDto dto){
     return new ResponseEntity<>(iCompteService.nouveauCompte(dto), HttpStatus.CREATED);
    }
    @PostMapping("/affectCompte")
    void attacheCompteToUtilisateur(@RequestParam (name = "utilisateurId") UtilisateurDto utilisateurId,
                                    @RequestParam (name = "compteId")CompteDto  compteId) {
        iCompteService.attacheCompteToUtilisateur(utilisateurId,compteId);
    }

}
