import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';
import { Patient } from 'src/app/list-patient/list-patient.component';

@Injectable({
  providedIn: 'root'
})
export class PatientDataService {

  constructor(private http:HttpClient) { }
  retrieveAllPatients(username:string){
    
      return this.http.get<Patient[]>(`${API_URL}/users/${username}/patients`);
  }
  deletePatient(username:string,id:string){
    return this.http.delete(`${API_URL}/users/${username}/patients/${id}`);
  }
  getPatient(username:string,id:string){
    return this.http.get<Patient>(`${API_URL}/users/${username}/patients/${id}`);
  }
  updatePatient(username:string,id:string,patient:Patient){
    return this.http.put(`${API_URL}/users/${username}/patients/${id}`,patient);
  }
  createPatient(username:string,patient:Patient){
    return this.http.post(`${API_URL}/users/${username}/patients`,patient);
  }

}
