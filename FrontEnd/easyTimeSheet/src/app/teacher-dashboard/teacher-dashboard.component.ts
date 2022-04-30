import { Component } from '@angular/core';
import {DataSource} from '@angular/cdk/collections';
import {Observable, ReplaySubject} from 'rxjs';

export interface ClassroomElement {
  name: string;
  position: number;
  numberOfStudents: number;
  numberOfLessons: number;
}

const ELEMENT_DATA: ClassroomElement[] = [
  {position: 1, name: 'Class 1', numberOfStudents: 12, numberOfLessons: 1},
  {position: 2, name: 'Class 2', numberOfStudents: 30, numberOfLessons: 7},
  {position: 3, name: 'Class 3', numberOfStudents: 20, numberOfLessons: 8},
  {position: 4, name: 'Class 4', numberOfStudents: 25, numberOfLessons: 10},
  {position: 5, name: 'Class 5', numberOfStudents: 18, numberOfLessons: 10},
  {position: 6, name: 'Class 6', numberOfStudents: 35, numberOfLessons: 8},
  {position: 7, name: 'Class 7', numberOfStudents: 31, numberOfLessons: 2},
  {position: 8, name: 'Class 8', numberOfStudents: 16, numberOfLessons: 10},
  {position: 9, name: 'Class 9', numberOfStudents: 22, numberOfLessons: 10},
  {position: 10, name: 'Class 10', numberOfStudents: 34, numberOfLessons: 5},
];

@Component({
  selector: 'app-teacher-dashboard',
  templateUrl: './teacher-dashboard.component.html',
  styleUrls: ['./teacher-dashboard.component.css']
})
export class TeacherDashboardComponent {

  displayedColumns: string[] = ['name', 'numberOfLessons', 'numberOfStudents', 'manageStudentsAttendance'];
  dataToDisplay = [...ELEMENT_DATA];

  dataSource = new ExampleDataSource(this.dataToDisplay);

  index = ELEMENT_DATA.length;

  addData() {
    const elementIndex = this.index + 1;
    const accessValues =  Math.floor(Math.random() * ELEMENT_DATA.length);
    this.dataToDisplay = [...this.dataToDisplay, ELEMENT_DATA[accessValues]];
    this.dataSource.setData(this.dataToDisplay);
  }

  removeData() {
    this.dataToDisplay = this.dataToDisplay.slice(0, -1);
    this.dataSource.setData(this.dataToDisplay);
  }
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
