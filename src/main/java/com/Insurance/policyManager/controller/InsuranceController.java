package com.Insurance.policyManager.controller;

import com.Insurance.policyManager.model.Policy;
import com.Insurance.policyManager.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;
    @PostMapping("/policy/save")
    public Policy   savePloicy(@RequestBody  Policy policy){
        return insuranceService.savePloicy(policy);
    }

    @PutMapping("/policy/{policyID}")
    public ResponseEntity<Policy> updatePloicy(@PathVariable("policyID") Integer policyID, @RequestBody  Policy policy){
        Optional<Policy>  optionalPolicy = insuranceService.getPloicyByID(policyID);
        if(optionalPolicy.isPresent()){
            Policy _policy = optionalPolicy.get();
            System.out.println(_policy);
            _policy.setCity(policy.getCity());
            _policy.setName(policy.getName());
            _policy.setCoverageAmout(policy.getCoverageAmout());
            _policy.setEnd(policy.getStart());
            _policy.setStart(policy.getStart());
            return  new ResponseEntity<>(insuranceService.updatePolicy(_policy), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PatchMapping("/policy/partial/{id}")
    public ResponseEntity<Policy>  patachPloicy(@PathVariable("id") Integer policyID, @RequestBody  Policy policy){
        Optional<Policy>  optionalPolicy = insuranceService.getPloicyByID(policyID);
        if(optionalPolicy.isPresent()){
            Policy _policy = optionalPolicy.get();
            System.out.println(_policy);
            _policy.setPolicyID(policyID);
            if(!StringUtils.isEmpty(policy.getCity()) )
                _policy.setCity(policy.getCity());
            if(!StringUtils.isEmpty(policy.getName()))
            _policy.setName(policy.getName());
            if(policy.getCoverageAmout() != null )
                _policy.setCoverageAmout(policy.getCoverageAmout());
            if(policy.getEnd() != null )
            _policy.setEnd(policy.getEnd());
            if(policy.getStart() != null )
            _policy.setStart(policy.getStart());
            return  new ResponseEntity<>(insuranceService.updatePolicy(_policy), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/policy/all")
    public List<Policy> getAllPloicies(){
        return insuranceService.getAllPloicies();
    }

    @GetMapping("/policy")
    public Policy getPloicyByID(@RequestParam Integer policyID) {
        return insuranceService.getPloicyByID(policyID).orElse(new  Policy());
   }

    @GetMapping("/policy/name")
    public Policy getPloicyByName(@RequestParam String name) {
        return insuranceService.getPloicyByName(name).orElse(new  Policy());
    }

    @GetMapping("/policy/sortbyname")
    public List<Policy> getAllPloiciesSortedByName(){
        List<Policy> policies = insuranceService.getAllPloicies().stream().sorted(Comparator.comparing(Policy::getName)).collect(Collectors.toList());
       ;
        return policies;
    }
    @GetMapping("/policy/bycity")
    public List<Policy> getAllPloiciesCity(@RequestParam String city){
        List<Policy> policies = insuranceService.getAllPloicies().stream().filter(x-> x.getCity().equals(city)).collect(Collectors.toList());
        return policies;
    }
    @DeleteMapping("/policy/{policyID}")
    public ResponseEntity<Policy> updatePloicy(@PathVariable("policyID") Integer policyID){
        Optional<Policy>  optionalPolicy = insuranceService.getPloicyByID(policyID);
        if(optionalPolicy.isPresent()){
            insuranceService.deletePolicy(optionalPolicy.get());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
