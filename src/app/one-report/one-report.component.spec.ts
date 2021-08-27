import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OneReportComponent } from './one-report.component';

describe('OneReportComponent', () => {
  let component: OneReportComponent;
  let fixture: ComponentFixture<OneReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OneReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OneReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
