import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { REPORT_JPA_API_URL } from 'src/app/app.constants';
import { ReportDB } from 'src/app/patient-reviews/patinet-reviews.component';
import { Report } from 'src/app/report/report.component';


@Injectable({
  providedIn: 'root'
})
export class ReportsDataService {

  constructor(private http:HttpClient) { }

  retrieveAllReports(username:String){
    return this.http.get<Report[]>(`${REPORT_JPA_API_URL}/users/${username}/reports`);

  }
  
  retrieveAllReportsDb(username:String){
    return this.http.get<ReportDB[]>(`${REPORT_JPA_API_URL}/users/${username}/reports`);

  }
  deleteReport(ID:number){
    console.log(`Brise se report pod id:  ${ID}`);
    return this.http.delete(`${REPORT_JPA_API_URL}/users/admin/reports/${ID}`);

  }
  retrieveReport(ID:number): Observable<Report> {
    return this.http.get<Report>(`${REPORT_JPA_API_URL}/users/admin/reports/${ID}`);

  }

  createReport(idReview:number,username:String,report:Report){
    console.log(report)
    return this.http.post(`${REPORT_JPA_API_URL}/users/${username}/reports/${idReview}/${report.id}`,report);
  }

  updateReport(username:String,id:number,report:Report){
    return this.http.put(`${REPORT_JPA_API_URL}/users/${username}/reports/${id}`,report);
  }
}