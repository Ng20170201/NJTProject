import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SimpleOuterSubscriber } from 'rxjs/internal/innerSubscribe';
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
    this.patient = new Patient(this.id, "", "", "", new Date(), "", "", "");



    if ( this.id!=-1) {

      this.patientService.getPatient('nikola', this.id).subscribe(
        
        data=>{
          this.patient = data;
          console.log("Patient ngOnInit()"+this.showPatient(this.patient));
        }
      )
    }

  }
  savePatient() {
    if (this.id ==-1 ) {
      //create todo
      this.patientService.createPatient('admin', this.patient).subscribe(
        response => {
          console.log("Save patient create: "+response);
          this.router.navigateByUrl("/list-patient");
        },error => {
          console.log('FAIL to create Patient!');
        },
        () => {
          console.log('POST Patient - now completed.');
        });
      
    } else {
      //update
      this.patientService.updatePatient('admin', this.id, this.patient).subscribe(
        response => {
          console.log("Save patient update: "+response);

          this.router.navigateByUrl("/list-patient");
        }
      )
    }
  }

  showPatient(patient:Patient){
    console.log(patient.id+" "+patient.name+" "+patient.surname);
  }


}
