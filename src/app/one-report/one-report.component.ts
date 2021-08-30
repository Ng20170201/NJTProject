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

id:number=0


report:Report= new Report(0,'','','') 


  constructor(private reportService:ReportsDataService,
    private route: ActivatedRoute,private router:Router) { }

  ngOnInit() {

    this.id=this.route.snapshot.params['id'];
   
      this.report=new Report(this.id,'','','')

   // this.report=new Report(1,1,'','',new Date());
    if(this.id!=-1 ){
      
    this.reportService.retrieveReport(this.id).subscribe(data=>{
      this.report=data
    //  this.office=this.report.office
    })
  }

   
}


  
  SaveReport(){

    if(this.id!=-1){
      console.log(this.id)
      console.log(this.id,'!=','-1')
   this.reportService.updateReport(this.id,this.report).subscribe(
     data=>{
       console.log(data)
       
       this.router.navigate(['report'])
     }
   )
    }
    else{

   console.log(this.id)
   console.log(this.id,'=','-1')
   this.reportService.createReport(this.report).subscribe(
     data=>{
       console.log(data)
       

       this.router.navigate(['report'])
     }
   )
    }
  }
}