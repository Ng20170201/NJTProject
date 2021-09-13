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
  errorMessage:string="Please fill in required input fields.";
  correct:boolean=true;
  constructor(
    private patientService: PatientDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {

    this.getDate();
    
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

maxDate:any = ""

getDate(){
  var date:any = new Date();
  var toDate:any = date.getDate();
  if(toDate < 10){
    toDate = '0' + toDate;
  }
  var month:any = date.getMonth() + 1;
  if(month < 10){
    month = '0' + month;
  }
  var year = date.getFullYear();
  this.maxDate = year + "-" + month + "-" + toDate;
}



  savePatient() {
    if(this.checkFields(this.patient)==false){
      return;
    }
    if (this.id ==-1 ) {
      //create todo
      this.patientService.createPatient('admin', this.patient).subscribe(
        response => {
          console.log("Save patient create: "+response);
          this.router.navigateByUrl("/list-patient");
        },error => {
          this.correct=false;
          this.errorMessage="Patient with this UCIN already exists."
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
  isNumber(str:string) {
    var pattern = /^\d+$/;
    return pattern.test(str);  // returns a boolean
}
  isEmailAddress(str:string) {
    var pattern =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return pattern.test(str);  // returns a boolean
}
isAfterToday(date:Date) {
  return new Date(date).valueOf() > new Date().valueOf();
}

  checkFields(patient:Patient) : boolean{
    if(patient.ucin.length !=13 || this.isNumber(patient.ucin)==false){
      console.log("Ne valja ucin")
      this.correct=false;
      this.errorMessage="Please insert correct values. UCIN length must be 13 digits."
      return false;
    }
    if(this.isEmailAddress(patient.email)==false){
      this.correct=false;
      this.errorMessage="Please insert correct values. Email form not valid."
      return false;
    }
  
    
    return true;
  }


}


 

