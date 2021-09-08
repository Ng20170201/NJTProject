import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { BasicAuthenticationService } from './basic-authentication.service';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardDoctorService {


  constructor( private hardcodedAuthenticationService: HardcodedAuthenticationService,private basicAuthService:BasicAuthenticationService,
    private router:Router) { }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.basicAuthService.isDoctorLoggedIn())
      
    return true;
    
    this.router.navigate(['login']);
  return false;
}
}