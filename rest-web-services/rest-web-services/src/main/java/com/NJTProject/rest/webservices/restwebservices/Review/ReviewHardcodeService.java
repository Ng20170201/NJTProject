package com.NJTProject.rest.webservices.restwebservices.Review;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ReviewHardcodeService {
	private static List<Review> reviews=new ArrayList();
	private static long idCounter=0;
	private static long jedan=1;
	
	static {
//		reviews.add(new Review(++idCounter,1,"Description1","Office1",new Date(),5));
//		reviews.add(new Review(++idCounter,1,"Description2","Office2",new Date(),6));
//		reviews.add(new Review(++idCounter,1,"Description3","Office3",new Date(),7));
	}
	public List<Review> findAll(){
		return reviews;
	}
	
	public Review deleteById(long doctorId,long patientId) {
		Review review=findById(doctorId,patientId);
		if(review==null) return null;
		if(reviews.remove(review)) {
		return review;
		}
		return null;
	
	}

	Review findById(long doctorId,long patientId) {
		for(Review review:reviews) {
			if(review.getPatient().getId()==patientId && review.getDoctor().getId()==doctorId) {
				return review;
			}
		}
		return null;
	}
	public Review save(Review review) {
//		if((review.getDoctorID()==-1 || review.getDoctorID()==0 )&& 
//				review.getPatientID()==-1 || review.getPatientID()==0) {
		if(review.getPatient().getId() == -1){
			review.getDoctor().setId(jedan);
			review.getPatient().setId(++idCounter);
			reviews.add(review);
			
		}
		else {
			deleteById(review.getDoctor().getId(), review.getPatient().getId());
			reviews.add(review);
		}
		return review;
	}

}
