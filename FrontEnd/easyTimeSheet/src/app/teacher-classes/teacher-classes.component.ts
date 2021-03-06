import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import {DataSource} from '@angular/cdk/collections';
import {Observable, ReplaySubject} from 'rxjs';
import { MatDialog} from '@angular/material/dialog';

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
  constructor(private _location: Location, public dialog: MatDialog) {}

  panelOpenState = false;

  backClicked() {
    this._location.back();
  }

  clickedButton(){
    console.log("Button Clicked");
  }

  openDialog() {
    const dialogRef = this.dialog.open(DialogElements);

    // usar esse subscribe para chamar a funcao de salvar a aula para o aluno no backend
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
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

@Component({
  selector: 'dialog-elements',
  templateUrl: 'dialog-elements.html'
})
export class DialogElements {
  constructor(public dialog: MatDialog) {}

  closeDialog(){
    console.log("trying to close");
    this.dialog.closeAll();
  }
}
