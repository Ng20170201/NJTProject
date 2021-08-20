import { TestBed } from '@angular/core/testing';

import { RouteGuardDoctorService } from './route-guard-doctor.service';

describe('RouteGuardDoctorService', () => {
  let service: RouteGuardDoctorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteGuardDoctorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
