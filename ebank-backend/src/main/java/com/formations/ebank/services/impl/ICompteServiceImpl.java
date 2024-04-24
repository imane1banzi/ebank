package com.formations.ebank.services.impl;

import com.formations.ebank.dtos.CompteDto;
import com.formations.ebank.dtos.UtilisateurDto;
import com.formations.ebank.entities.Compte;
import com.formations.ebank.entities.Utilisateur;
import com.formations.ebank.repositories.CompteJpaRepo;
import com.formations.ebank.services.ICompteService;
import com.formations.ebank.utils.CustomModelMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional

public class ICompteServiceImpl implements ICompteService {

    private  final CompteJpaRepo compteJpaRepo;
private final CustomModelMapper customModelMapper;

    public ICompteServiceImpl(CompteJpaRepo compteJpaRepo, CustomModelMapper customModelMapper) {
        this.compteJpaRepo = compteJpaRepo;
        this.customModelMapper = customModelMapper;
    }

    @Override
    public CompteDto nouveauCompte(CompteDto compteDto) {

        try {
              Compte compteBo=  this.customModelMapper.modelMapper().map(compteDto,Compte.class);
            var savedCompteBo =this.compteJpaRepo.save(compteBo);

            return customModelMapper.modelMapper().map(savedCompteBo,CompteDto.class);
        }catch (Exception e){

            return null;
        }

    }

    @Override
    public List<CompteDto> listeCompte() {
        return null;
    }

    @Override
    public List<CompteDto> listeCompteByUtilisateur(UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public void attacheCompteToUtilisateur(UtilisateurDto utilisateurDto, CompteDto compteDto) {

        try {

        }catch (Exception e){

        }
    }

    @Override
    public CompteDto chercherCompteParRib(String rib) {

        return customModelMapper.modelMapper()
                .map(this.compteJpaRepo.findCompteByRib(rib).get(),CompteDto.class);
    }


}
