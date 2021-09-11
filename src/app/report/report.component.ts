import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportDB } from '../patient-reviews/patinet-reviews.component';
import { AUTHENTICATED_USER } from '../service/basic-authentication.service';
import { ReportsDataService } from '../service/data/reports-data.service';

// export class Report{
//   constructor(
//     public patientID:number,
//     public doctorID:number,
//     public office:string,
//     public description: string,
//     public date: Date
//   ){

//   }
  
// }
export class Report{
  constructor(
    public id:number,
    public diagnosis:string,
    public therapy:string,
    public note: string,
    public doctorId:number,
    public patientId:number,
    public date:Date

  ){

  }
  
}

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})


export class ReportComponent implements OnInit {
  reports:Array<ReportDB>=new Array<ReportDB>()
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
      this.reportsservice.retrieveAllReportsDb(sessionStorage.getItem(AUTHENTICATED_USER)+"").subscribe(
        response=>{
     
          this.reports=response;
          console.log(this.reports);
        }
      )
  }
  deleteReport( id:number){
    
      console.log(`delete report ${id}`)
  
      this.reportsservice.deleteReport(id).subscribe(
        response=>{
          console.log(response);
         
          this.message=`Delete of Report ${id}... Delete Successfull`
            this.refreshReports();
          }
          
        
      )
  }
  updateReport(id:number){
    this.router.navigate(['reports',`${id}`])

  }

  
}
