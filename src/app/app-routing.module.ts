import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { ListPatientComponent } from './list-patient/list-patient.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { OneReportComponent } from './one-report/one-report.component';
import { OneReviewComponent } from './one-review/one-review.component';
import { PatientReportsComponent } from './patient-reports/patient-reports.component';
import { PatinetReviewComponent } from './patient-reviews/patinet-reviews.component';
import { PatientComponent } from './patient/patient.component';
import { ReportComponent } from './report/report.component';
import { ReviewComponent } from './review/review.component';
import { RouteGuardDoctorService } from './service/route-guard-doctor.service';
import { RouteGuardService } from './service/route-guard.service';
import { WelcomeDoctorComponent } from './welcome-doctor/welcome-doctor.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [

  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'welcome/:name',component:WelcomeComponent, canActivate:[RouteGuardService]},
  {path:'welcome-doctor/:name',component:WelcomeDoctorComponent,canActivate:[RouteGuardDoctorService]},
  {path:'list-patient',component:ListPatientComponent,canActivate:[RouteGuardDoctorService]},
  {path:'logout',component:LogoutComponent},
  {path:'review',component:ReviewComponent,canActivate:[RouteGuardDoctorService]},
  {path:'report',component:ReportComponent,canActivate:[RouteGuardDoctorService]},
  {path:'patient-reviews',component:PatinetReviewComponent,canActivate:[RouteGuardService]},
  {path:'patient-reports',component:PatientReportsComponent,canActivate:[RouteGuardService]},
  {path:'patients/:id',component:PatientComponent,canActivate:[RouteGuardDoctorService]},
  {path:'reports/:idReview/:id',component:OneReportComponent,canActivate:[RouteGuardDoctorService]},
  {path:'reports/:id',component:OneReportComponent,canActivate:[RouteGuardDoctorService]},
  {path:'reviews/:id',component:OneReviewComponent,canActivate:[RouteGuardDoctorService]},
  {path:'reviews/:id1/:id2',component:OneReviewComponent,canActivate:[RouteGuardDoctorService]},

  {path:'**',component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
