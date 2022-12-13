package com.Insurance.policyManager.repository;

import com.Insurance.policyManager.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Policy, Integer> {
    Optional<Policy> getByName(String name);
}
