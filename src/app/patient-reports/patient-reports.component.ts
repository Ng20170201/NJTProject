import { Component, OnInit } from '@angular/core';
import { Report } from '../report/report.component';
import { ReportsDataService } from '../service/data/reports-data.service';

@Component({
  selector: 'app-patient-reports',
  templateUrl: './patient-reports.component.html',
  styleUrls: ['./patient-reports.component.css']
})
export class PatientReportsComponent implements OnInit {
  reports:Array<Report>=new Array<Report>()
  message : String=""
  // reports=[]
  // reports=[
  //    new Report(1,1,'Office1','Description1', new Date),
  //    new Report(2,2,'Office2','Description1',new Date),
  //   new Report(3,3,'Office3','Description1',new Date)

  //  ]

  constructor(private reportsservice: ReportsDataService) { }

  ngOnInit(): void {
    this.reportsservice.retrieveAllReports('nikola').subscribe(
      response=>{
        console.log(response);
        this.reports=response;
      }
    )
  }

}
