import { TestBed } from '@angular/core/testing';

import { UserDashService } from './user-dash.service';

describe('UserDashService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserDashService = TestBed.get(UserDashService);
    expect(service).toBeTruthy();
  });
});
