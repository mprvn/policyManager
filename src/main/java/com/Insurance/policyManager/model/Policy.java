package com.Insurance.policyManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Integer policyID;
    String name;
    Integer age;
    Double coverageAmout;
    LocalDateTime start;
    LocalDateTime end;
    String city;
}
