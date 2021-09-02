import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  REPORT_JPA_API_URL } from 'src/app/app.constants';
import { Patient } from 'src/app/list-patient/list-patient.component';

@Injectable({
  providedIn: 'root'
})
export class PatientDataService {

  constructor(private http:HttpClient) { }
  retrieveAllPatients(username:string){
    
      return this.http.get<Patient[]>(`${REPORT_JPA_API_URL}/users/${username}/patients`);
  }
  deletePatient(username:string,id:number){
    return this.http.delete(`${REPORT_JPA_API_URL}/users/${username}/patients/${id}`);
  }
  getPatient(username:string,id:number){
    return this.http.get<Patient>(`${REPORT_JPA_API_URL}/users/${username}/patients/${id}`);
  }
  updatePatient(username:string,id:number,patient:Patient){
    return this.http.put(`${REPORT_JPA_API_URL}/users/${username}/patients/${id}`,patient);
  }
  createPatient(username:string,patient:Patient){
    return this.http.post(`${REPORT_JPA_API_URL}/users/${username}/patients`,patient);
  }

}
