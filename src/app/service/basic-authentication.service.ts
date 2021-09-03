import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { API_URL } from '../app.constants';


export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticaterUser'




@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http: HttpClient) { }
  authenticateDoctor(username:string ,password:string){
    //console.log('before ' + this.isUserLoggedIn());
    if(username==="admin" && password==="admin"){
      sessionStorage.setItem(AUTHENTICATED_USER,username);
     // console.log('after ' + this.isUserLoggedIn());
      return true;
    }
    return false;
  }


  // authenticate(username:string ,password:string){
  //   //console.log('before ' + this.isUserLoggedIn());
  //   if(username==="nikola" && password==="nikola"){
  //     sessionStorage.setItem('authenticaterUser',username);
  //    // console.log('after ' + this.isUserLoggedIn());
  //     return true;
  //   }
  //   return false;
  // }
  executeAuthenticationService(username:string ,password:string){
   

    let basicAuthHeaderString = 'Basic '+ window.btoa(username + ':' + password);
    

  let headers = new HttpHeaders({
    Authorization:  basicAuthHeaderString
  }

  )
  return this.http.get<AuthenticationBean>(`${API_URL}/basicauth`,
  {headers}).pipe(
    map(
      (      data: any) =>{
        sessionStorage.setItem(AUTHENTICATED_USER,username);
        sessionStorage.setItem(TOKEN, basicAuthHeaderString);

        return data;
      }
    )
  
    
  );
}
  
executeAuthenticationServiceDoctor(username:string ,password:string){
  
  let basicAuthHeaderString = 'Basic '+ window.btoa(username + ':' + password);
    

  let headers = new HttpHeaders({
    Authorization:  basicAuthHeaderString
  }

  )
  return this.http.get<AuthenticationBean>(`http://localhost:8080/basicauth`,
  {headers}).pipe(
    map(
      (      data: any) =>{
        sessionStorage.setItem(AUTHENTICATED_USER,username);
        sessionStorage.setItem(TOKEN, basicAuthHeaderString);

        return data;
      }
    )

  );
  


}

executeJWTAuthenticationService(username:string ,password:string){
   


return this.http.post<any>(`${API_URL}/authenticate`,{username,password}).pipe(
  map(
    (      data: any) =>{
      sessionStorage.setItem(AUTHENTICATED_USER,username);
      sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
      return data;
    }
  )

  
);
}



getAuthenticatedUser(){
  return sessionStorage.getItem(AUTHENTICATED_USER)
  
}

getAuthenticatedToken(){
  // if(this.getAuthenticatedUser()){
  return  sessionStorage.getItem(TOKEN)
  // }
  
}


  isUserLoggedIn(){
    let user = sessionStorage.getItem(AUTHENTICATED_USER)
    if(user==='nikola')
    return true;
    return false;
  }
  isDoctorLoggedIn(){
    let user = sessionStorage.getItem(AUTHENTICATED_USER)
    if(user==='admin')
    return true;
    return false;
  }
  logout(){
 
    sessionStorage.removeItem(AUTHENTICATED_USER)
    sessionStorage.removeItem(TOKEN)
  }

}

export class AuthenticationBean{
  constructor(public message:String){

  }

}
