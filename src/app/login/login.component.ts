import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
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
  



  constructor(private router: Router,
    private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService) { }

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
      //}
           
      // if(this.basicAuthenticationService.executeAuthenticationServiceDoctor(this.username,this.password)){
      //   this.basicAuthenticationService.executeAuthenticationServiceDoctor(this.username,this.password)
      //   .subscribe(
      //     data =>{
      //       console.log(data)
      //       this.router.navigate(['welcome', this.username])
      //        this.invalidLogin=false

      //     },
      //     error=>{
      //       console.log(error)
      //       this.invalidLogin=true

      //     }
          
      //   )
      // this.router.navigate(['welcome', this.username])
      // this.invalidLogin=false
      // }
    }

}
