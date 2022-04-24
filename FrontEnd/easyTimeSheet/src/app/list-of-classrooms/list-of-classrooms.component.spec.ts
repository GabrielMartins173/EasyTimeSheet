import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfClassroomsComponent } from './list-of-classrooms.component';

describe('ListOfClassroomsComponent', () => {
  let component: ListOfClassroomsComponent;
  let fixture: ComponentFixture<ListOfClassroomsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOfClassroomsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfClassroomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
