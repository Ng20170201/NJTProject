import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient, PatientDB } from '../list-patient/list-patient.component';
import { DoctorDB } from '../patient-reviews/patinet-reviews.component';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
import { DoctorDataService } from '../service/data/doctor-data.service';
import { PatientDataService } from '../service/data/patient-data.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username='nikola'
  password='nikola'
  errorMessage='Invalid '
  invalidLogin=false
  doctors:Array<DoctorDB>=new Array<DoctorDB>()
  patients:Array<PatientDB>=new Array<PatientDB>()



  constructor(private router: Router,
    private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService,
    private patientService:PatientDataService, private doctorService:DoctorDataService) { }

  ngOnInit(): void {
  
  }
    handleLogin(){
      if(this.hardcodedAuthenticationService.authenticate(this.username,this.password)){
        this.router.navigate(['welcome', this.username])
        this.invalidLogin=false
      }
           else {
         this.invalidLogin=true
      }
      if(this.hardcodedAuthenticationService.authenticateDoctor(this.username,this.password)){
        this.router.navigate(['welcome-doctor', this.username])
        this.invalidLogin=false
      }
           else {
         this.invalidLogin=true
      }
    }

    handleBasicAuthLogin(){
     
      // if(this.basicAuthenticationService.executeAuthenticationService(this.username,this.password)){
      this.basicAuthenticationService.executeAuthenticationService(this.username,this.password)
          .subscribe(
            data =>{
              console.log(data)
              this.router.navigate(['welcome', this.username])
               this.invalidLogin=false

            },
            error=>{
              console.log(error)
              this.invalidLogin=true

            }
            
          )
        this.router.navigate(['welcome', this.username])
        this.invalidLogin=false

    }

    handleJWTAuthLogin(){
      
    
      this.basicAuthenticationService.executeJWTAuthenticationService(this.username,this.password)
  
          .subscribe(
          
            data =>{
              console.log(data)
              this.patientService.retrieveAllPatientsWU().subscribe(
                response=>{
             
                  this.patients=response;
                  console.log(this.patients);
                  if(this.CheckRolePat(this.patients,this.username)=="patient"){
                    console.log("pacijent je")
                  this.router.navigate(['welcome', this.username])
                  return
                  }
                  
                }
              )
              this.doctorService.retrieveAllDoctorsWU().subscribe(
                response=>{
             
                  this.doctors=response;
                  console.log(this.doctors);
                  if(this.CheckRoleDoc(this.doctors,this.username)=="doctor"){
                    console.log("doktor je")
                    this.router.navigate(['welcome-doctor', this.username])
                    return
                  }
                }
              )
             
          
           
              console.log(this.username);
              
               this.invalidLogin=false

            },
            error=>{
              console.log(error)
              this.invalidLogin=true

            }
            
          )
       
        


        
    }

    CheckRolePat(patients:Array<PatientDB>,userName:string){
      
     
     
    
      for(let i=0;i<patients.length;i++){
        
        if(userName==patients[i].ucin){
          return 'patient';
      }
     
    }
    return 'no';
  }
  CheckRoleDoc(doctors: Array<DoctorDB>,userName:string){
      
     
     
    for(let i=0;i<doctors.length;i++){
     
        if(userName==doctors[i].username){
        return 'doctor';
        }
    }
   
      return 'no';
}
}
