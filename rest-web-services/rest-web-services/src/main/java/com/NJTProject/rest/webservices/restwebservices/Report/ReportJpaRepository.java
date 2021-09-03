package com.NJTProject.rest.webservices.restwebservices.Report;

import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportJpaRepository extends JpaRepositoryImplementation<Report, Long>{
	
	

	List<Report> findById(String username);
	List<Report> findAll();
	

}
