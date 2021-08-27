import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from '../report/report.component';
import { ReportsDataService } from '../service/data/reports-data.service';

@Component({
  selector: 'app-one-report',
  templateUrl: './one-report.component.html',
  styleUrls: ['./one-report.component.css']
})
export class OneReportComponent implements OnInit {

patientId:number=0
doctorId:number=0
office:string=''
report:Report= new Report(0,0,'','',new Date()) 


  constructor(private reportService:ReportsDataService,
    private route: ActivatedRoute,private router:Router) { }

  ngOnInit() {

    this.patientId=this.route.snapshot.params['patientId'];
    this.doctorId=this.route.snapshot.params['doctorId'];
      this.report=new Report(this.patientId,this.doctorId,'','',new Date())

   // this.report=new Report(1,1,'','',new Date());
    if(this.doctorId!=-1 && this.patientId!=-1){
   
    this.reportService.retrieveReport(this.doctorId,this.patientId).subscribe(data=>{
      this.report=data
    //  this.office=this.report.office
    })
  }
   
}


  
  SaveReport(){
    if(this.patientId===-1 && this.doctorId===-1){
      this.reportService.createReport(this.report).subscribe(
        data=>{
          console.log(data)
          this.router.navigate(['report'])
        }
      )
    }
    else{
   this.reportService.updateReport(this.patientId,this.doctorId,this.report).subscribe(
     data=>{
       console.log(data)
       this.router.navigate(['report'])
     }
   )
    }
  }
}
