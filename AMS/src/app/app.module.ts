import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {DatePipe} from '@angular/common';
import { Routes,RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { SPAModule } from './spa/spa.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {StandardModule} from './standard/standard.module';
import {JobModule} from './job/job.module';
import{AdminModule} from './admin/admin.module';
import { StudentModule } from './student/student.module';
import {AlumniModule} from './alumni/alumni.module';
import{FeedbackModule} from './feedback/feedback.module';

import { StudentService } from './services/student.service';
import {AlumniService} from './services/alumni.service';
import {LoginService} from './services/login.service';
import {JobDetailService} from './services/job-details.service';
import {JobService} from './services/Job.service';
import {CityService} from './services/city.service';
import { BatchService } from './services/batch.service';
import {FeedbackService} from './services/feedback.service';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    StandardModule,
    SPAModule,
    AdminModule,
    StudentModule,
    AlumniModule,
    JobModule,
    FeedbackModule,
    RouterModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot() // ToastrModule added
    
    
    
  ],
  exports:[],
  providers: [StudentService,
    LoginService,
    BatchService,
    AlumniService,
    CityService,
    JobDetailService,
  JobService,
FeedbackService],
  bootstrap: [AppComponent]
})
export class AppModule { }
