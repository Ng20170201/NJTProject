import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportsDataService } from '../service/data/reports-data.service';

export class Report{
  constructor(
    public patientID:number,
    public doctorID:number,
    public office:string,
    public description: string,
    public date: Date
  ){

  }
  
}

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})


export class ReportComponent implements OnInit {
  reports:Array<Report>=new Array<Report>()
  message : String=""
 //  reports=[]
  //reports=[
  //   new Report(1,1,'Office1','Description1','Date1'),
  //   new Report(2,2,'Office2','Description1','Date2'),
  //   new Report(3,3,'Office3','Description1','Date3')

  // ]
  constructor( private reportsservice: ReportsDataService,
    private router:Router) {
  
   }

  ngOnInit(): void {
    
    this.refreshReports();
   
  }
  refreshReports(){
      this.reportsservice.retrieveAllReports('admin').subscribe(
        response=>{
          console.log(response);
          this.reports=response;
        }
      )
  }
  deleteReport( patientID:number, doctorID:number){
    
      console.log(`delete report ${doctorID}-${patientID}`)
  
      this.reportsservice.deleteReport(doctorID,patientID).subscribe(
        response=>{
          console.log(response);
         
          this.message=`Delete of Report ${doctorID}-${patientID}... Delete Successfull`
            this.refreshReports();
          }
          
        
      )
  }
  updateReport(patientID:number,doctorID:number){
    this.router.navigate(['reports',`${doctorID}`,`${patientID}`])

  }
  addReport(){
    this.router.navigate(['reports',-1,-1])

  }
  
}
