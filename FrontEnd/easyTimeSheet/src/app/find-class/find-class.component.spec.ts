import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindClassComponent } from './find-class.component';

describe('FindClassComponent', () => {
  let component: FindClassComponent;
  let fixture: ComponentFixture<FindClassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindClassComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
