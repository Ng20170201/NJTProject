import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
  



  constructor(private router: Router) { }

  ngOnInit(): void {
  
  }
    handleLogin(){
      if(this.username==="nikola" && this.password==="nikola"){
        this.router.navigate(['welcome', this.username])
        this.invalidLogin=false
      }
      else {
        this.invalidLogin=true
      }
    }
}
