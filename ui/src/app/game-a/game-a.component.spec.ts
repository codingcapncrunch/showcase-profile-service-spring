import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameAComponent } from './game-a.component';

describe('GameAComponent', () => {
  let component: GameAComponent;
  let fixture: ComponentFixture<GameAComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameAComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
