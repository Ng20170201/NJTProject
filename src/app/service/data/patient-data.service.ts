import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from 'src/app/list-patient/list-patient.component';

@Injectable({
  providedIn: 'root'
})
export class PatientDataService {

  constructor(private http:HttpClient) { }
  retrieveAllPatients(username:string){
    
      return this.http.get<Patient[]>(`http://localhost:8080/users/${username}/patients`);
  }
  deletePatient(username:string,id:string){
    return this.http.delete(`http://localhost:8080/users/${username}/patients/${id}`);
  }
  getPatient(username:string,id:string){
    return this.http.get<Patient>(`http://localhost:8080/users/${username}/patients/${id}`);
  }
  updatePatient(username:string,id:string,patient:Patient){
    return this.http.put(`http://localhost:8080/users/${username}/patients/${id}`,patient);
  }
  createPatient(username:string,patient:Patient){
    return this.http.post(`http://localhost:8080/users/${username}/patients`,patient);
  }

}
