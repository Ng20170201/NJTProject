import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.constants';
import { Report } from 'src/app/report/report.component';


@Injectable({
  providedIn: 'root'
})
export class ReportsDataService {

  constructor(private http:HttpClient) { }

  retrieveAllReports(username:String){
    return this.http.get<Report[]>(`http://localhost:8080/users/${username}/reports`);

  }
  
  deleteReport(ID:number){
    return this.http.delete(`${API_URL}/users/admin/reports/${ID}`);

  }
  retrieveReport(ID:number): Observable<Report> {
    return this.http.get<Report>(`${API_URL}/users/admin/reports/${ID}`);

  }

  createReport(report:Report){
    return this.http.post(`${API_URL}/users/admin/reports/${report.id}`,report);
  }

  updateReport(id:number,report:Report){
    return this.http.put(`${API_URL}/users/admin/reports/${id}`,report);
  }
}