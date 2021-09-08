import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from '../report/report.component';
import { AUTHENTICATED_USER } from '../service/basic-authentication.service';
import { ReportsDataService } from '../service/data/reports-data.service';

@Component({
  selector: 'app-one-report',
  templateUrl: './one-report.component.html',
  styleUrls: ['./one-report.component.css']
})
export class OneReportComponent implements OnInit {

id:number=0
idReview:number=0

report:Report= new Report(0,'','','',0,0,new Date()) 


  constructor(private reportService:ReportsDataService,
    private route: ActivatedRoute,private router:Router) { }

  ngOnInit() {

    this.id=this.route.snapshot.params['id'];
    this.idReview=this.route.snapshot.params['idReview'];
      this.report=new Report(this.id,'','','',0,0,new Date())

   // this.report=new Report(1,1,'','',new Date());
    if(this.id!=-1 ){
      
    this.reportService.retrieveReport(this.id).subscribe(data=>{
      this.report=data
      console.log("Ovo je report",data);
    //  this.office=this.report.office
    })
  }

   
}


  
  SaveReport(){
 
    if(this.id!=-1){
    
   this.reportService.updateReport(sessionStorage.getItem(AUTHENTICATED_USER)+"",this.id,this.report).subscribe(
     data=>{
       console.log(data)

       this.router.navigate(['report'])
       
     }
   )
    }
    else{


   this.reportService.createReport(this.idReview,sessionStorage.getItem(AUTHENTICATED_USER)+"",this.report).subscribe(
     data=>{
       console.log(data)
       
       this.router.navigate(['report'])
     }
   )
    }
  }
}