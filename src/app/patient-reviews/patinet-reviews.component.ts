import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { PatientDataService } from '../service/data/patient-data.service';
import { ReviewsDataService } from '../service/data/reviews-data.service';


export class Review{
constructor(
  public patientID:number,
  public doctorID:number,
  public office:string,
  public description: string,
  public date: Date,
  public periodID:number
  
){}
}

@Component({
  selector: 'app-patinet-reviews',
  templateUrl: './patinet-reviews.component.html',
  styleUrls: ['./patinet-reviews.component.css']
})



export class PatinetReviewsComponent implements OnInit {
 
  message : String=""
  closeResult:string=""
  reviews:Array<Review>=new Array<Review>()
  
  //    new Review(1,'Diagnosis 1','Therapy 1','Note 1'),
  //    new Review(2,'Diagnosis 2','Therapy 2','Note 2'),
  //    new Review(3,'Diagnosis 3','Therapy 3','Note 3')

  //  ]
   
constructor(private reviewsservice: ReviewsDataService
  // private httpClient:HttpClient,
  // private modalService:NgbModule,
  // private modalDismiss:ModalDismissReasons,
  // private router:Router

){

}
 

  ngOnInit(): void {
    this.reviewsservice.retrieveAllReviews('nikola').subscribe(
      response=>{
        console.log(response);
        this.reviews=response;
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


