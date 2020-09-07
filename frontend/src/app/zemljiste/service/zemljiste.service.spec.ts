import { TestBed } from '@angular/core/testing';

import { ZemljisteService } from './zemljiste.service';

describe('ZemljisteService', () => {
  let service: ZemljisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZemljisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
