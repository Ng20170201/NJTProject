import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatinetReviewComponent } from './patinet-reviews.component';

describe('PatinetReviewsComponent', () => {
  let component: PatinetReviewComponent;
  let fixture: ComponentFixture<PatinetReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatinetReviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatinetReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
