package com.NJTProject.rest.webservices.restwebservices.doctor;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.NJTProject.rest.webservices.restwebservices.Report.Report;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;

@Repository
public interface DoctorJpaRepository extends JpaRepositoryImplementation<Doctor, Long> {
	List<Doctor> findAll();

	Doctor findByUsername(String username);

	

	
}
