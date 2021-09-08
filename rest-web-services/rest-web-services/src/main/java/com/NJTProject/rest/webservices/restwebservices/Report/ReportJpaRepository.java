package com.NJTProject.rest.webservices.restwebservices.Report;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportJpaRepository extends JpaRepositoryImplementation<Report, Long>{
	
	

//	public List<Report> findByUsername(String username);
	public Report findById(long id);
	List<Report> findAll();
	

}
