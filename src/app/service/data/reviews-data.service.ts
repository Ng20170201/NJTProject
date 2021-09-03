import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {REPORT_JPA_API_URL, API_URL } from 'src/app/app.constants';
import { Review } from 'src/app/patient-reviews/patinet-reviews.component';

@Injectable({
  providedIn: 'root'
})
export class ReviewsDataService {

  constructor(private http:HttpClient) { }


  retrieveAllReviews(username:String){
    let basicAuthHeaderString = this.cretaeBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization:  basicAuthHeaderString
    }

    )
    return this.http.get<Review[]>(`${REPORT_JPA_API_URL}/users/${username}/reviews`,
    {headers : headers});

  }
  
  deleteReview(doctorID:number,patientID:number){
    return this.http.delete(`${API_URL}/users/admin/reviews/${doctorID}/${patientID}`);

  }
  retrieveReviews(patientID:number): Observable<Review> {
    return this.http.get<Review>(`${API_URL}/users/admin/reviews/1/${patientID}`);

  }

  createReview(review:Review){
    return this.http.post(`${API_URL}/users/admin/reviews/1/${review.patientID}`,review);
  }

  updateReview(id1:number,id2:number,review:Review){
    return this.http.put(`${API_URL}/users/admin/reviews/${id1}/${id2}`,review);
  }

cretaeBasicAuthenticationHttpHeader(){
  let username='admin'
  let password ='dummy'
  let basicAuthHeaderString = 'Basic '+ window.btoa(username + ':' + password);
  return basicAuthHeaderString;
}




}
