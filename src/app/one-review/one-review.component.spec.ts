import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OneReviewComponent } from './one-review.component';

describe('OneReviewComponent', () => {
  let component: OneReviewComponent;
  let fixture: ComponentFixture<OneReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OneReviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OneReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
