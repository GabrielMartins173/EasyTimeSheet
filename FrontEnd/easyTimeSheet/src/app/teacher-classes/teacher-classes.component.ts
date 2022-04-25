import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import {DataSource} from '@angular/cdk/collections';
import {Observable, ReplaySubject} from 'rxjs';

export interface ClassroomElement {
  name: string;
  position: number;
  status: string;
}

const ELEMENT_DATA: ClassroomElement[] = [
  {position: 1, name: 'Student 1', status: 'Present'},
  {position: 2, name: 'Student 2', status: 'Present'},
  {position: 3, name: 'Student 3', status: 'Present'},
  {position: 4, name: 'Student 4', status: 'Absence'},
  {position: 5, name: 'Student 5', status: 'Present'},
  {position: 6, name: 'Student 6', status: 'Present'},
  {position: 7, name: 'Student 7', status: 'Present'},
  {position: 8, name: 'Student 8', status: 'Present'},
  {position: 9, name: 'Student 9', status: 'Absence'},
  {position: 10, name: 'Student 10', status: 'Present'},
];


@Component({
  selector: 'app-teacher-classes',
  templateUrl: './teacher-classes.component.html',
  styleUrls: ['./teacher-classes.component.css'],
})
export class TeacherClassesComponent implements OnInit {
  constructor(private _location: Location) {}

  panelOpenState = false;

  backClicked() {
    this._location.back();
  }

  ngOnInit(): void {}

  displayedColumns: string[] = ['name', 'status', 'changeStudentAttendance'];
  dataToDisplay = [...ELEMENT_DATA];

  dataSource = new ExampleDataSource(this.dataToDisplay);

  index = ELEMENT_DATA.length;
}

class ExampleDataSource extends DataSource<ClassroomElement> {
  private _dataStream = new ReplaySubject<ClassroomElement[]>();

  constructor(initialData: ClassroomElement[]) {
    super();
    this.setData(initialData);
  }

  connect(): Observable<ClassroomElement[]> {
    return this._dataStream;
  }

  disconnect() {}

  setData(data: ClassroomElement[]) {
    this._dataStream.next(data);
  }
}

