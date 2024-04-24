package com.formations.ebank.repositories;

import com.formations.ebank.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurJpaRepo extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findByLogin(String login);


    Optional<Utilisateur> findById(Integer integer);
    Optional<Utilisateur> findByLoginAndPassword(String login,String password);
}
