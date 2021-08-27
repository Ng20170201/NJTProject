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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientResource {

    @Autowired
    private PatientHardcodedService patientService;

    @GetMapping("/users/{username}/patients")
    public List<Patient> getAllPatients(@PathVariable String username) {
        return patientService.findAll();
    }

    @GetMapping("/users/{username}/patients/{id}")
    public Patient getPatient(@PathVariable String username, @PathVariable String id) {
        return patientService.findPatientById(id);
    }

    @DeleteMapping("/users/{username}/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String username, @PathVariable String id) {
        Patient patient = patientService.deletePatientById(id);
        if (patient != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String username, @PathVariable String id, @RequestBody Patient patient) {
        Patient patientUpdated = patientService.save(patient);
        System.out.println("Procitan pacijent u put mapping: "+patient);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/patients")
    public ResponseEntity<Void> addPatient(@PathVariable String username, @RequestBody Patient patient) {
        System.out.println("Procitan pacijent: "+patient);
        Patient patentAdded = patientService.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patentAdded.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
