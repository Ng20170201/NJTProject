/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.patient;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Andjela
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PatientsJPAResource {
    
    @Autowired
    private PatientHardcodedService patientService;
      @Autowired
    private PatientsJpaRepository patientsJpaRepository;

    @GetMapping("/jpa/users/{username}/patients")
    public List<Patient> getAllPatients(@PathVariable String username) {
        //return patientService.findAll();
        return patientsJpaRepository.findAll();
    }

    @GetMapping("/jpa/users/{username}/patients/{id}")
    public Patient getPatient(@PathVariable String username, @PathVariable long id) {
       // return patientService.findPatientById(id);
       return patientsJpaRepository.findById(id).get();
    }

    @DeleteMapping("/jpa/users/{username}/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String username, @PathVariable long id) {
      
        patientsJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jpa/users/{username}/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String username, @PathVariable String id, @RequestBody Patient patient) {
        Patient patientUpdated = patientsJpaRepository.save(patient);
       // System.out.println("Procitan pacijent u put mapping: "+patient);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/patients")
    public ResponseEntity<Void> createPatient(@PathVariable String username, @RequestBody Patient patient) {
        System.out.println("Procitan pacijent: "+patient);
        Patient patentAdded = patientsJpaRepository.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patentAdded.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
