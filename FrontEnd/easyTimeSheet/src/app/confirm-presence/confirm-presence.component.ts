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
  {position: 1, name: 'Lesson 1', status: 'Present'},
  {position: 2, name: 'Lesson 2', status: 'Present'},
  {position: 3, name: 'Lesson 3', status: 'Present'},
  {position: 4, name: 'Lesson 4', status: 'Absence'},
  {position: 5, name: 'Lesson 5', status: 'Present'},
  {position: 6, name: 'Lesson 6', status: 'This Is Today\'s Lesson'},
  {position: 7, name: 'Lesson 7', status: 'Future Lesson'},
  {position: 8, name: 'Lesson 8', status: 'Future Lesson'},
  {position: 9, name: 'Lesson 9', status: 'Future Lesson'},
  {position: 10, name: 'Lesson 10', status: 'Future Lesson'},
];


@Component({
  selector: 'app-confirm-presence',
  templateUrl: './confirm-presence.component.html',
  styleUrls: ['./confirm-presence.component.css'],
})
export class ConfirmPresenceComponent implements OnInit {
  constructor(private _location: Location, public dialog: MatDialog) {}

  panelOpenState = false;

  backClicked() {
    this._location.back();
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

  isDisabled(): boolean{
    var status = 'this.'

    if(status == 'This Is Today\'s Lesson'){
      return true
    }

    return false;
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
