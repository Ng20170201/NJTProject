import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorDB, Review, ReviewDB } from '../patient-reviews/patinet-reviews.component';
import { AUTHENTICATED_USER } from '../service/basic-authentication.service';
import { ReviewsDataService } from '../service/data/reviews-data.service';
// import { Review } from '../patient-reviews/patient-reviews.component';



@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  message: string='';
  reviews:ReviewDB[]=[];
  doctor?:DoctorDB;

  constructor(
    private reviewService: ReviewsDataService,
    private router: Router
  ) { }

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
  deleteReview(id: number,patientid:number,doctorid:number) {

    
    this.reviewService.deleteReviewDB(id,patientid,doctorid).subscribe(
    
      response => {
        console.log(response);

        this.message = `You have successfully deleted chosen review!`
        this.refreshReviews();
      }


    )
  }
  updateReview(id: number) {
    
    this.router.navigate(['reviews',sessionStorage.getItem(AUTHENTICATED_USER), id]);

  }
  addReview() {
    this.router.navigate(['reviews', sessionStorage.getItem(AUTHENTICATED_USER), -1])
  }

  addReport(){
    this.router.navigate(['reports',-1])

  }


}
