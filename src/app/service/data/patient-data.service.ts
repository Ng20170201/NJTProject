import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  REPORT_JPA_API_URL } from 'src/app/app.constants';
import { Patient, PatientDB } from 'src/app/list-patient/list-patient.component';



@Injectable({
  providedIn: 'root'
})
export class PatientDataService {

  constructor(private http:HttpClient) { }
  
  searchByText(username:string,searchText:String){
   
    return this.http.get<PatientDB[]>(`${REPORT_JPA_API_URL}/users/${username}/patients/search/${searchText}`);
}

  retrieveAllPatients(username:string){
    
      return this.http.get<PatientDB[]>(`${REPORT_JPA_API_URL}/users/${username}/patients`);
  }
  retrieveAllPatientsWU(){
    
    return this.http.get<PatientDB[]>(`${REPORT_JPA_API_URL}/users/patients`);
}
  deletePatient(username:string,id:number){
    console.log(`Brise se PATIENT  pod id:  ${id}`)
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
