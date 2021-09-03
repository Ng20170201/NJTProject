import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Review } from '../patient-reviews/patinet-reviews.component';
import { ReviewsDataService } from '../service/data/reviews-data.service';

@Component({
  selector: 'app-one-review',
  templateUrl: './one-review.component.html',
  styleUrls: ['./one-review.component.css']
})
export class OneReviewComponent implements OnInit {


  id2: number = 0


  review: Review = new Review(0, 1, '', '', new Date(), 0)

  constructor(private reviewService: ReviewsDataService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id2 = this.route.snapshot.params['id2'];

    this.review = new Review(this.id2, 1, '', '', new Date(), null)

    // this.report=new Report(1,1,'','',new Date());
    if (this.id2 != -1) {

      this.reviewService.retrieveReviews(this.id2).subscribe(data => {
        this.review = data
        //  this.office=this.report.office
      })
    }
  }


  SaveReview() {
    console.log('uslo u saveReview')
    if (this.id2 != -1) {
      console.log(this.id2)
      console.log(this.id2, '!=', '-1')
      this.reviewService.updateReview(1, this.id2, this.review).subscribe(
        data => {
          console.log(data)

          this.router.navigate(['review'])
        }
      )
    }
    else {

      console.log(this.id2)
      console.log(this.id2, '=', '-1')
      this.reviewService.createReview(this.review).subscribe(
        data => {
          console.log(data)


          this.router.navigate(['review'])
        }
      )
    }
  }
}
