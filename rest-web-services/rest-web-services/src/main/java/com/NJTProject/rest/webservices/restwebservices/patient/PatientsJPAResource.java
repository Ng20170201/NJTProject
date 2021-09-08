/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.patient;

import com.NJTProject.rest.webservices.restwebservices.jwt.JwtInMemoryUserDetailsService;
import java.net.URI;
import java.util.ArrayList;
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
public class PatientsJPAResource {

    @Autowired
    private PatientHardcodedService patientService;
    @Autowired
    private PatientsJpaRepository patientsJpaRepository;
    private JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService;

    @GetMapping("/jpa/users/{username}/patients")
    public List<Patient> getAllPatients(@PathVariable String username){
        List<Patient> patients = patientsJpaRepository.findAll();
        return patients;

    }
    
    @GetMapping("/jpa/users/patients")
    public List<Patient> getAllPatientsWU(){
        List<Patient> patients = patientsJpaRepository.findAll();
        return patients;

    } 
    @GetMapping("/jpa/users/{username}/patients/search/{SearchText}")
    public  List<Patient> searchByText(@PathVariable String username, @PathVariable String SearchText) {
        // return patientService.findPatientById(id);
    	List<Patient> patients=getAllPatients(username);
    	List<Patient> returnPatient=new ArrayList<Patient>();
   	
    	for(int i=0;i<patients.size();i++) {
    		
    		
    		if(patients.get(i).getName().toLowerCase().contains(SearchText.toLowerCase()) || patients.get(i).getSurname().toLowerCase().contains(SearchText.toLowerCase())) {
    			returnPatient.add(patients.get(i));
    		}
    	}
    
    	return returnPatient;

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
    public ResponseEntity<Void> createPatient(@PathVariable String username, @RequestBody Patient patient) throws Exception {
        System.out.println("DODAT pacijent: " + patient);
        List<Patient> patients=patientsJpaRepository.findAll();
        for(Patient p : patients){
            if(p.getUCIN().equals(patient.getUCIN())){
              throw new Exception();
            }
                
        }
        
        Patient patentAdded = patientsJpaRepository.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patentAdded.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
