import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from 'src/app/patient-reviews/patinet-reviews.component';

@Injectable({
  providedIn: 'root'
})
export class ReviewsDataService {

  constructor(private http:HttpClient) { }


  retrieveAllReviews(username:String){
    return this.http.get<Review[]>(`http://localhost:8080/users/${username}/reviews`);

  }
  
  deleteReview(doctorID:number,patientID:number){
    return this.http.delete(`http://localhost:8080/users/admin/reviews/${doctorID}/${patientID}`);

  }
  retrieveReviews(patientID:number): Observable<Review> {
    return this.http.get<Review>(`http://localhost:8080/users/admin/reviews/1/${patientID}`);

  }

  createReview(review:Review){
    return this.http.post(`http://localhost:8080/users/admin/reviews/1/${review.patientID}`,review);
  }

  updateReview(id1:number,id2:number,review:Review){
    return this.http.put(`http://localhost:8080/users/admin/reviews/${id1}/${id2}`,review);
  }
}
