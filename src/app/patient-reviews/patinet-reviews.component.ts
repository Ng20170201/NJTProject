import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { PatientDataService } from '../service/data/patient-data.service';
import { ReviewsDataService } from '../service/data/reviews-data.service';
import { PatientDB } from '../list-patient/list-patient.component';
import { AUTHENTICATED_USER } from '../service/basic-authentication.service';


export class Review {
  constructor(
    public id:number,
    public patientId: number,
    public doctorId: number,
    public office: string,
    public description: string,
    public date: Date

  ) { }
}
export class DoctorDB {
  constructor(
    public id: number,
    public name: string,
    public surname: string,
    public specialization: string,
    public workingshift: string,
    public username: string,
    public password: string,
    public department:DepartmentDB|null

  ) { }
}
export class ReviewDB {
  constructor(
    public id:number,
    public patient: PatientDB,
    public doctor: DoctorDB,
    public office: string,
    public description: string,
    public date: Date,
   public reports:ReportDB[]|null
  ) { }
}
export class ReportDB {
  constructor(
    public id:number,
    public note: string,
    public diagnosis: string,
    public therapy: string,
    public review:ReviewDB|null
  ) { }
}
export class DepartmentDB{
  constructor(
    public id:number,
    public name:string
  ){}
}


@Component({
  selector: 'app-patinet-reviews',
  templateUrl: './patinet-reviews.component.html',
  styleUrls: ['./patinet-reviews.component.css']
})



export class PatinetReviewComponent implements OnInit {

  message: String = ""
  closeResult: string = ""
  reviews: ReviewDB[] = [];
  
 
  constructor(
    private reviewService: ReviewsDataService,
  

  ) {

  }


  ngOnInit(): void {
   this.refreshReviews();
  }
  
  refreshReviews() {
    
    this.reviewService.retrieveAllReviews(sessionStorage.getItem(AUTHENTICATED_USER)+"").subscribe(
     
        response=>{
     
          this.reviews=response;
          console.log(this.reviews);
        }
      
    )
  }

  // private getDismissReason(reason: any): string {
  //   if (reason === ModalDismissReasons.ESC) {
  //     return 'by pressing ESC';
  //   } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
  //     return 'by clicking on a backdrop';
  //   } else {
  //     return `with: ${reason}`;
  //   }
  // }




  // open(contentDetails:any){
  //   this.modalService.open(contentDetails, {ariaLabelledBy: 'modal-basic-title'}).result.then((closeResult:any) => {
  //     this.closeResult = `Closed with: ${closeResult}`;
  //   }, (reason) => {
  //     this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  //   });

  // }



}


