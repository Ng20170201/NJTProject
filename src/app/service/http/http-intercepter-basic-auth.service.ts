import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor{

  constructor(
    private basicAuthenticationService : BasicAuthenticationService,
    private http: HttpClient
  ) { }



  intercept(request: HttpRequest<any>, next: HttpHandler) {
  //   let username='admin'
  // let password ='dummy'
  //let basicAuthHeaderString = 'Basic '+ window.btoa(username + ':' + password);
  let basicAuthHeaderString = this.basicAuthenticationService.getAuthenticatedToken();
  let username = this.basicAuthenticationService.getAuthenticatedUser()

  if(basicAuthHeaderString && username){

  request = request.clone({
    setHeaders:{
      Authorization:basicAuthHeaderString
    }
  }

  )
}
  return next.handle(request);
}
  }
  
  

