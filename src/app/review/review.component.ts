import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Review, ReviewDB } from '../patient-reviews/patinet-reviews.component';
import { ReviewsDataService } from '../service/data/reviews-data.service';
// import { Review } from '../patient-reviews/patient-reviews.component';



@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  reviews: Review[]=[];
  message: string='';
  reviewsDb:ReviewDB[]=[];

  constructor(
    private reviewService: ReviewsDataService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.refreshReviews();
  }

  refreshReviews() {
    this.reviewService.retrieveAllReviews('admin').subscribe(
      response => {
        this.reviewsDb=response;
        console.log("OVDEEEEE")
        this.reviewsDb.forEach(element => {
          console.log("OVDE "+ element)
          this.reviews.push( new Review(element.id,element.patient.id,element.doctor.id,element.office,element.description,element.date));
        });
      
      }
    )
  }
  deleteReview(idD: number, idP: number) {

    console.log(`delete report ${idD} AND ${idP}`)

    this.reviewService.deleteReview(idD).subscribe(
      response => {
        console.log(response);

        this.message = `Delete of Report ${idD} and ${idP}... Delete Successfull`
        this.refreshReviews();
      }


    )
  }
  updateReview(idD: number, idP: number) {
    this.router.navigate(['reviews', 1, `${idP}`])

  }
  addReview() {
    this.router.navigate(['reviews', 1, -1]) //zakucan id doktora na 1

  }




}
