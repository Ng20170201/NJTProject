package com.NJTProject.rest.webservices.restwebservices.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.NJTProject.rest.webservices.restwebservices.Report.ReportJpaRepository;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DoctorJpaResource {
	@Autowired
	private DoctorJpaRepository doctorJpaRepository;
	
	 @GetMapping("/jpa/users/{username}/doctors")
	    public List<Doctor> getAllPatients(@PathVariable String username){
	        List<Doctor> doctors = doctorJpaRepository.findAll();
	        return doctors;

	    }
	 
	  @GetMapping("/jpa/users/doctors")
	    public List<Doctor> getAllDoctorsWU(){
	        List<Doctor> doctors = doctorJpaRepository.findAll();
	        return doctors;

	    } 
}
