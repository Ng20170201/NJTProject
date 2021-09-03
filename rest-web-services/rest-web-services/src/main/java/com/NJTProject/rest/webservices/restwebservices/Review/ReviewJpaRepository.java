package com.NJTProject.rest.webservices.restwebservices.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review,Long> {

	List<Review> findAll();






}
