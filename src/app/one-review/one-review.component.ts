import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SimpleOuterSubscriber } from 'rxjs/internal/innerSubscribe';
import { Patient, PatientDB } from '../list-patient/list-patient.component';
import { DepartmentDB, DoctorDB,  Review, ReviewDB } from '../patient-reviews/patinet-reviews.component';
import { PatientDataService } from '../service/data/patient-data.service';
import { ReviewsDataService } from '../service/data/reviews-data.service';

@Component({
  selector: 'app-one-review',
  templateUrl: './one-review.component.html',
  styleUrls: ['./one-review.component.css']
})
export class OneReviewComponent implements OnInit {


  id2: number = 0
  isDisabled:boolean=false;
  department:DepartmentDB =new DepartmentDB(111,"Surgery");
  dummyDoctor:DoctorDB=new DoctorDB(123,"Pera","Peric","surgeon","3","pera","pera",this.department);
  dummyPatient:PatientDB=new PatientDB(0,"","","",new Date(),"","","",null);
 

  review: Review = new Review(this.id2,0, 1, '', '', new Date())
  reviewDb:ReviewDB= new ReviewDB(this.id2,this.dummyPatient,this.dummyDoctor,"","",new Date(),null);

  //PACIJENTI
  patients:Patient[]=[];
  patientsDB:PatientDB[]=[];
  selectedPatient:Patient=new Patient(0,"NA","NA","NA",new Date(),"NA","NA","NA");

  //PACIJENT POLJE
  patient:Patient=new Patient(0,"NA","NA","NA",new Date(),"NA","NA","NA");


  constructor(private reviewService: ReviewsDataService,
    private route: ActivatedRoute, private router: Router,private patientService:PatientDataService) { }

  ngOnInit(): void {
//uzimanje pacijenata
   this.patientService.retrieveAllPatients('admin').subscribe(
     response=>{  
       this.patientsDB=response;
       this.patientsDB.forEach(element => {
         this.patients.push(new Patient(element.id,element.ucin,element.name,element.surname,element.birthDate,element.email,element.telephone,element.password));
       });

     }
   )


    this.id2 = this.route.snapshot.params['id2'];

    this.review = new Review(this.id2,this.id2, 1, '', '', new Date())
     this.reviewDb=new ReviewDB(this.id2,this.dummyPatient,this.dummyDoctor,"","",new Date(),null);

    if (this.id2 != -1) {
      this.isDisabled=true;
      this.reviewService.getReviewById(this.id2,'admin').subscribe(data => {
        console.log("Get review by id -> office: "+data.office);
        this.reviewDb = data;
        this.patient=this.reviewDb.patient;
        this.review=new Review(this.id2,this.reviewDb.patient.id,this.reviewDb.doctor.id,this.reviewDb.office,this.reviewDb.description,this.reviewDb.date);
        
      
     
      })
    }
  }

  
    SaveReview() {
      console.log("POZVANA SAVE REVIEW METODA");
      
    if (this.id2 ==-1 ) {
      //create todo
      console.log("create review office: "+this.reviewDb.office);
      this.reviewService.createReviewDB('admin', this.reviewDb).subscribe(
        response => {
          console.log("ODGOVOR"+response);
          this.router.navigateByUrl("/review");
        }, error => {
          console.log('FAIL to create Review!');
        },
        () => {
          console.log('POST Review - now completed.');
        });
      
    } else {
      //update
      console.log("UPDATE REVIEW")
      this.reviewService.updateReviewDB('admin',this.id2,this.reviewDb).subscribe(
        response => {
          console.log("Response review: \n"+response);
          this.router.navigateByUrl("/review");
        }, error => {
          console.log('FAIL to update Review!');
        },
        () => {
          console.log('PUT Review - now completed.');
        });
      
    }
  }
  onChange(newPatient:Patient){
    console.log(newPatient);
    this.selectedPatient=newPatient;
    this.dummyPatient=new PatientDB(newPatient.id,newPatient.ucin,newPatient.name,newPatient.surname,newPatient.birthDate,newPatient.email,newPatient.telephone,newPatient.password,null);
    this.reviewDb.patient=this.dummyPatient;
  }
  
}
