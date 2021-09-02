import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientDataService } from '../service/data/patient-data.service';

export class Patient {
  constructor(
    public id: number,
    public ucin: number|null,
    public name: string,
    public surname: string,
    public birthDate: Date,
    public email: string,
    public telephone: string,
    public password: string

  ) {

  }
}


@Component({
  selector: 'app-list-patient',
  templateUrl: './list-patient.component.html',
  styleUrls: ['./list-patient.component.css']
})
export class ListPatientComponent implements OnInit {
  patients: Patient[] = [];
  message!: string;


  constructor(
    private patientService: PatientDataService,
    private router:Router
  ) {
  }

  ngOnInit(): void {
    this.refreshPatients();
  }
  refreshPatients() {
    this.patientService.retrieveAllPatients('admin').subscribe(
      response => {
        console.log(response);
        this.patients = response;
      }
    )
  }

  deletePatient(id: number) {
    this.patientService.deletePatient('admin', id).subscribe(
      response => {
        console.log("Successful deleting: " + response);
        this.message = "Successful deleting";
        this.refreshPatients();
      },
      error => {
        console.log("Error while deleting")
        this.message = "Error while deleting";
      }
    )

  }
  updatePatient(id:number){
    console.log(`update ${id}`)
    this.router.navigateByUrl(`patients/${id}`);
  }
  addPatient(){
    this.router.navigate(['patients',-1]);
  }
}
