import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../list-patient/list-patient.component';
import { PatientDataService } from '../service/data/patient-data.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  id: number=0;
  patient!: Patient;
  constructor(
    private patientService: PatientDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {


    this.id = this.route.snapshot.params['id'];
    this.patient = new Patient(this.id, null, "", "", new Date(), "", "", "");



    if ( this.id!=-1) {

      this.patientService.getPatient('nikola', this.id).subscribe(
        data => this.patient = data
      )
    }

  }
  savePatient() {
    if (this.id ==-1 ) {
      //create todo
      this.patientService.createPatient('admin', this.patient).subscribe(
        response => {
          console.log(response);
          this.router.navigateByUrl("/list-patient");
        }
      )
    } else {
      //update
      this.patientService.updatePatient('admin', this.id, this.patient).subscribe(
        response => {
          console.log("Response: \n"+response);
          this.router.navigateByUrl("/list-patient");
        }
      )
    }
  }


}
