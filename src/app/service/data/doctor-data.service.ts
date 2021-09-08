import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { REPORT_JPA_API_URL } from 'src/app/app.constants';
import { DoctorDB } from 'src/app/patient-reviews/patinet-reviews.component';

@Injectable({
  providedIn: 'root'
})
export class DoctorDataService {

  constructor(private http:HttpClient) {
  
   }
   retrieveAllDoctorsWU(){
    
    return this.http.get<DoctorDB[]>(`${REPORT_JPA_API_URL}/users/doctors`);
}
}
