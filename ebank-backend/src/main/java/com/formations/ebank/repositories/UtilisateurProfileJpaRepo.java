package com.formations.ebank.repositories;

import com.formations.ebank.entities.UtilisateurProfile;
import com.formations.ebank.entities.UtilisateurProfileKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurProfileJpaRepo extends
        JpaRepository<UtilisateurProfile, UtilisateurProfileKey> {

}
