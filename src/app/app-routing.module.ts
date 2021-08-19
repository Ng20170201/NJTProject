import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { ListPatientComponent } from './list-patient/list-patient.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [

  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'welcome/:name',component:WelcomeComponent},
  {path:'list-patient',component:ListPatientComponent},
  {path:'**',component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
