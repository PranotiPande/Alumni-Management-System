import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StandardModule} from '../standard/standard.module';
import { ContainerComponent } from './container/container.component';
import { Routes,RouterModule } from '@angular/router';
import { HomeComponent } from '../standard/home/home.component';
import { ContactusComponent } from '../standard/contactus/contactus.component';
import { LoginComponent } from '../standard/login/login.component';
import { SignupComponent } from '../standard/signup/signup.component';
import { AdminComponent } from '../admin/admin/admin.component';
import { BatchComponent } from '../batch/batch/batch.component';
import { StudentComponent } from '../student/student/student.component';
import {AlumniComponent} from '../alumni/alumni/alumni.component';
import { FooterComponent } from './footer/footer.component';
import { JobComponent } from '../job/job/job.component';
import { JobOpeningsComponent } from '../student/job-openings/job-openings.component';

const routes:Routes=[
  {path:'',redirectTo:'home',pathMatch:'full'},
 {path:'home',component:HomeComponent},
  {path:'contactus',component:ContactusComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'admin',component:AdminComponent},
  {path:'batch',component:BatchComponent},
  {path:'student/:id',component:StudentComponent},
  {path:'alumni/:id',component:AlumniComponent},
  {path:'jobopen',component:JobOpeningsComponent}
]

@NgModule({
  declarations: [ ContainerComponent, FooterComponent],
  imports: [
    StandardModule,
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[
    FooterComponent,
    ContainerComponent
  ]
})
export class SPAModule { }
