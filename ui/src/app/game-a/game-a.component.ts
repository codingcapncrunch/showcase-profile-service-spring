import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-game-a',
  templateUrl: './game-a.component.html',
  styleUrls: ['./game-a.component.css']
})
export class GameAComponent implements OnInit {

  invalidSelection = false;
  invalidFormMessage = '';
  gridCheckAdditionValue = true;
  gridCheckSubtractionValue = false;
  gridCheckMultiplicationValue = false;
  gridCheckDivisionValue = false;
  gameOperation = '+';
  gameNumberOne = 10;
  gameNumberTwo = 15;
  gameNumberThree = 25;

  constructor() { }

  ngOnInit(): void {
  }

  submitGameConfig(){

    if (!this.gridCheckAdditionValue && !this.gridCheckSubtractionValue && !this.gridCheckMultiplicationValue && !this.gridCheckDivisionValue){
      this.invalidFormMessage = 'Please select at least one operation.';
      this.invalidSelection = true;
    } else {
      this.invalidFormMessage = '';
      this.invalidSelection = false;
    }

  }


}
