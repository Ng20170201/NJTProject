import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatinetReviewsComponent } from './patinet-reviews.component';

describe('PatinetReviewsComponent', () => {
  let component: PatinetReviewsComponent;
  let fixture: ComponentFixture<PatinetReviewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatinetReviewsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatinetReviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
