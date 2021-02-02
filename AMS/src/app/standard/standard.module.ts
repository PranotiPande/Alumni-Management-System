import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ContactusComponent } from './contactus/contactus.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [HomeComponent, LoginComponent, SignupComponent, ContactusComponent],
  imports: [
    FormsModule,
    CommonModule
    
  ],
  exports:[
    HomeComponent,
    LoginComponent,
    SignupComponent,
    ContactusComponent
  ]
})
export class StandardModule { }
