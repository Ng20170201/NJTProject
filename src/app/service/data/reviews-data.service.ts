import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {REPORT_JPA_API_URL, API_URL } from 'src/app/app.constants';
import { Review, ReviewDB } from 'src/app/patient-reviews/patinet-reviews.component';

@Injectable({
  providedIn: 'root'
})
export class ReviewsDataService {

  constructor(private http:HttpClient) { }


  retrieveAllReviews(username:String){
  
    return this.http.get<ReviewDB[]>(`${REPORT_JPA_API_URL}/users/${username}/reviews`);

  }
  /*
  
  deleteReview(id:number){
    return this.http.delete(`${API_URL}/users/admin/reviews/${id}`);

  }*/
 
  getReviewById(id:number,username:string) {
    return this.http.get<ReviewDB>(`${REPORT_JPA_API_URL}/users/${username}/reviews/${id}`);

  }

/*

  createReview(username:string,review:Review){
    return this.http.post(`${REPORT_JPA_API_URL}/users/${username}/reviews/123/${review.patientId}`,review);
  }

  updateReview(username:string,id2:number,review:Review){
    return this.http.put(`${REPORT_JPA_API_URL}/users/${username}/reviews/${id2}`,review);
  }*/

  
  createReviewDB(username:string,reviewDb:ReviewDB):Observable<any> {
   return this.http.post(`${REPORT_JPA_API_URL}/users/${username}/reviews`,reviewDb);
  }
  updateReviewDB(username:string,id:number,reviewDb:ReviewDB){
    return this.http.put(`${REPORT_JPA_API_URL}/users/${username}/reviews/${id}`,reviewDb);
  }
  /*deleteReviewDB(id:number){
    return this.http.delete(`${REPORT_JPA_API_URL}/users/admin/reviews/${id}`);


    deleteReviewDB(id:number,idP:number,idD:number){
    return this.http.delete(`${REPORT_JPA_API_URL}/users/admin/reviews/${id}/${idP}/${idD}`);

  }

  }*/
  deleteReviewDB(id:number,idP:number,idD:number){
    return this.http.delete(`${REPORT_JPA_API_URL}/users/admin/reviews/${id}/${idP}/${idD}`);

  }


cretaeBasicAuthenticationHttpHeader(){
  let username='admin'
  let password ='dummy'
  let basicAuthHeaderString = 'Basic '+ window.btoa(username + ':' + password);
  return basicAuthHeaderString;
}




}
