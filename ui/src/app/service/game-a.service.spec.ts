import { TestBed } from '@angular/core/testing';

import { GameAService } from './game-a.service';

describe('GameAService', () => {
  let service: GameAService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GameAService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
