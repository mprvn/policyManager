package com.Insurance.policyManager.service;

import com.Insurance.policyManager.model.Policy;
import com.Insurance.policyManager.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public Policy savePloicy(Policy policy) {
        return insuranceRepository.save(policy);
    }

    public List<Policy> getAllPloicies() {
        return insuranceRepository.findAll();
    }

    public Optional<Policy> getPloicyByID(Integer polciyID) {
        return insuranceRepository.findById(polciyID);
    }

    public Optional<Policy> getPloicyByName(String name) {
        return insuranceRepository.getByName(name);
    }

    public Policy updatePolicy(Policy policy) {
        return insuranceRepository.save(policy);
    }

    public void deletePolicy(Policy policy) {
         insuranceRepository.delete(policy);
    }
}
