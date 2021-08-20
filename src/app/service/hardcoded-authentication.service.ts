import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }
  authenticateDoctor(username:string ,password:string){
    //console.log('before ' + this.isUserLoggedIn());
    if(username==="admin" && password==="admin"){
      sessionStorage.setItem('authenticaterUser',username);
     // console.log('after ' + this.isUserLoggedIn());
      return true;
    }
    return false;
  }


  authenticate(username:string ,password:string){
    //console.log('before ' + this.isUserLoggedIn());
    if(username==="nikola" && password==="nikola"){
      sessionStorage.setItem('authenticaterUser',username);
     // console.log('after ' + this.isUserLoggedIn());
      return true;
    }
    return false;
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticaterUser')
    if(user==='nikola')
    return true;
    return false;
  }
  isDoctorLoggedIn(){
    let user = sessionStorage.getItem('authenticaterUser')
    if(user==='admin')
    return true;
    return false;
  }
  logout(){
 
    sessionStorage.removeItem('authenticaterUser')
  }

}
