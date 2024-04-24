package com.formations.ebank.repositories;

import com.formations.ebank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationJpaRepo  extends JpaRepository<Operation,Integer> {
    @Override
    Optional<Operation> findById(Integer integer);
}
