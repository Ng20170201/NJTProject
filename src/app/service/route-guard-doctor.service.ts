import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardDoctorService {


  constructor( private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private router:Router) { }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.hardcodedAuthenticationService.isDoctorLoggedIn())
      
    return true;
    
    this.router.navigate(['login']);
  return false;
}
}