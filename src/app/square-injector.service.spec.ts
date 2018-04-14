import { TestBed, inject } from '@angular/core/testing';

import { SquareInjectorService } from './square-injector.service';

describe('SquareInjectorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SquareInjectorService]
    });
  });

  it('should be created', inject([SquareInjectorService], (service: SquareInjectorService) => {
    expect(service).toBeTruthy();
  }));
});
