package com.NJTProject.rest.webservices.restwebservices.Review;

import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepositoryImplementation<Review,Long> {

	List<Review> findAll();
	public void deleteById(long Id);
//    public void deleteByIdAndPatientAndDoctor(long id, long patientid, long doctorid);






}
