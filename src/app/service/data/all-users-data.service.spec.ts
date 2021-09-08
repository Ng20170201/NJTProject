import { TestBed } from '@angular/core/testing';

import { AllUsersDataService } from './all-users-data.service';

describe('AllUsersDataService', () => {
  let service: AllUsersDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllUsersDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
