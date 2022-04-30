import { Component } from '@angular/core';
import { MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-find-class',
  templateUrl: './find-class.component.html',
  styleUrls: ['./find-class.component.css'],
})
export class FindClassComponent {
  constructor(public dialog: MatDialog) {}

  openDialog() {
    const dialogRef = this.dialog.open(DialogElements);

    // usar esse subscribe para chamar a funcao de salvar a aula para o aluno no backend
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}

@Component({
  selector: 'dialog-elements',
  templateUrl: 'dialog-elements.html',
  styleUrls: ['./find-class.component.css'],
})
export class DialogElements {
  constructor(public dialog: MatDialog) {}

  closeDialog(){
    console.log("trying to close");
    this.dialog.closeAll();
  }
}
