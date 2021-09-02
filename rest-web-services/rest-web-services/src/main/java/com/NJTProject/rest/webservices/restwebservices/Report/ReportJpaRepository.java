package com.NJTProject.rest.webservices.restwebservices.Report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportJpaRepository extends JpaRepository<Report, Long>{
	
	

	List<Report> findById(String username);
	List<Report> findAll();
	

}
