/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.patient;

import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andjela
 */
@Repository
public interface PatientsJpaRepository extends JpaRepositoryImplementation<Patient, Long> {

	//List<Patient> findByUsername(String username);
	List<Patient> findAll();


    public Patient findByUCIN(String username);
	
    
}
