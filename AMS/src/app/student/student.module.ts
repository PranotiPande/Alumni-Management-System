import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentComponent } from './student/student.component';
import { RouterModule, Routes } from '@angular/router';
import {UserDtlsComponent} from '../student/user-dtls/user-dtls.component';
import { AlumniListComponent } from './alumni-list/alumni-list.component';
import { JobOpeningsComponent } from './job-openings/job-openings.component';


@NgModule({
  declarations: [StudentComponent,UserDtlsComponent, AlumniListComponent, JobOpeningsComponent],
  imports: [
    CommonModule
  ],
  exports:[
    StudentComponent,
    UserDtlsComponent,
  ]
})
export class StudentModule { }
