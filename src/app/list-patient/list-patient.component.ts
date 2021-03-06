import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReviewDB } from '../patient-reviews/patinet-reviews.component';
import { PatientDataService } from '../service/data/patient-data.service';

export class Patient {
  constructor(
    public id: number,
    public ucin: string,
    public name: string,
    public surname: string,
    public birthDate: Date,
    public email: string,
    public telephone: string,
    public password: string

  ) {

  }
}
export class PatientDB {
  constructor(
    public id: number,
    public ucin: string,
    public name: string,
    public surname: string,
    public birthDate: Date,
    public email: string,
    public telephone: string,
    public password: string,
    public reviews:ReviewDB[]|null

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
  patientsDB:PatientDB[]=[];
  searchText:String="";

  constructor(
    private patientService: PatientDataService,
    private router:Router
  ) {
  }

  ngOnInit(): void {
    this.refreshPatients();
  }

searchPatient(){
  this.patients=[];
  if(this.searchText!=null && this.searchText!=""){
  this.patientService.searchByText('admin',this.searchText).subscribe(
  
    response=>{
      this.patients=response;
      console.log("=====",this.patients);
    }
  )
  }
  else{
    this.refreshPatients();
  }
}

  refreshPatients() {
    this.patients=[];
    this.patientService.retrieveAllPatients('admin').subscribe(
      response => {
        console.log(response);
       // this.patients = response;
       this.patientsDB=response;
        this.patientsDB.forEach(element => {
          this.patients.push(new Patient(element.id,element.ucin,element.name,element.surname,element.birthDate,element.email,element.telephone,element.password));
        });
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
