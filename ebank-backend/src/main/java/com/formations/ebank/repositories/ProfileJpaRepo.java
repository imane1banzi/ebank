package com.formations.ebank.repositories;

import com.formations.ebank.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileJpaRepo extends JpaRepository<Profile,Integer> {

    Optional<Profile> findById(Integer id);
}
