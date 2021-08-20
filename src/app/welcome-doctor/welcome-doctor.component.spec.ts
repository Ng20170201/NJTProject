import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomeDoctorComponent } from './welcome-doctor.component';

describe('WelcomeDoctorComponent', () => {
  let component: WelcomeDoctorComponent;
  let fixture: ComponentFixture<WelcomeDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WelcomeDoctorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WelcomeDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
