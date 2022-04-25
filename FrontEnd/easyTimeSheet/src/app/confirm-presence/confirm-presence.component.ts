import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'app-confirm-presence',
  templateUrl: './confirm-presence.component.html',
  styleUrls: ['./confirm-presence.component.css']
})
export class ConfirmPresenceComponent implements OnInit {

  constructor(private _location: Location) { }

  ngOnInit(): void {
  }

  backClicked() {
    this._location.back();
  }

}
