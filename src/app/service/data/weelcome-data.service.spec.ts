import { TestBed } from '@angular/core/testing';

import { WeelcomeDataService } from './weelcome-data.service';

describe('WeelcomeDataService', () => {
  let service: WeelcomeDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeelcomeDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
