package com.formations.ebank.repositories;

import com.formations.ebank.entities.Compte;
import com.formations.ebank.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompteJpaRepo extends JpaRepository<Compte,Integer> {
    //CRUD

    @Override
    Optional<Compte> findById(Integer integer);


    List<Compte> findByUtilisateur(Utilisateur utilisateur);
    Optional<Compte>findCompteByRib(String rib);


}
