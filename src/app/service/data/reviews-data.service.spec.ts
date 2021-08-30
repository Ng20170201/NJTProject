import { TestBed } from '@angular/core/testing';

import { ReviewsDataService } from './reviews-data.service';

describe('ReviewsDataService', () => {
  let service: ReviewsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReviewsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
