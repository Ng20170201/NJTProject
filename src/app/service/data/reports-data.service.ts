import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Report } from 'src/app/report/report.component';


@Injectable({
  providedIn: 'root'
})
export class ReportsDataService {

  constructor(private http:HttpClient) { }

  retrieveAllReports(username:String){
    return this.http.get<Report[]>(`http://localhost:8080/users/${username}/reports`);
    //console.log("Execute Hello World Bean Service")
  }
  
  deleteReport(username:number,patientId:number){
    return this.http.delete(`http://localhost:8080/users/admin/reports/${username}/${patientId}`);

  }
  retrieveReport(doctorId:number,patientId:number): Observable<Report> {
    return this.http.get<Report>(`http://localhost:8080/users/admin/reports/${doctorId}/${patientId}`);

  }

  createReport(report:Report){
    return this.http.post(`http://localhost:8080/users/admin/reports/${report.doctorID}/${report.patientID}`,report);
  }

  updateReport(patientId:number,doctorId:number,report:Report){
    return this.http.put(`http://localhost:8080/users/admin/reports/${doctorId}/${patientId}`,report);
  }
}
