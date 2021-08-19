import { Component, OnInit } from '@angular/core';

export class Patient{
  constructor(
    public id:number,
    public firstname:string,
    public lastname:string
  ){

  }
}

@Component({
  selector: 'app-list-patient',
  templateUrl: './list-patient.component.html',
  styleUrls: ['./list-patient.component.css']
})
export class ListPatientComponent implements OnInit {

  // patient ={
  //   id:1,
  //   firstname:'Nikola',
  //   lastname:'Golubovic'
  // }
  patients=[
    new Patient(1,'Nikola','Golubovic'),
    new Patient(2,'Milica','Cakerevic'),
    new Patient(3,'Andjela','Filipovic')

  ]

  
  constructor() { }

  ngOnInit(): void {
  }

}
