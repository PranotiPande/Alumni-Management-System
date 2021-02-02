import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import {Login} from '../../models/login.model';
import {LoginService} from '../../services/login.service';
import {StudentService} from '../../services/student.service';
import {Student} from '../../models/student.model';
import{Batch} from '../../models/batch.model';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
email:string;
password:string;



  
@Input("lob") log:Login
@Output() myevent=new EventEmitter();
constructor(private loginservice:LoginService ,private router:Router,private studentservice:StudentService,private toastr:ToastrService){}
  ngOnInit(): void {
  }
      authenticatestudent(){
         let l=new Login(this.email,this.password)
         this.loginservice.authenticateStudent(this.email,this.password)
         .subscribe(response=>{
           if(response['status']=="success"){
          console.log(response);
          const data=response['data'];
              if(data['role']=="STUDENT"){
                   sessionStorage['firstName']=data['firstName'];
                   sessionStorage['lastName']=data['lastName'];
                   sessionStorage['id']=data['id'];
                   sessionStorage['address']=data['address'];
                   sessionStorage['cityId']=data['cityId'];
                   sessionStorage['stateId']=data['stateId'];
                   sessionStorage['countryId']=data['countryId'];
                   sessionStorage['email']=data['email'];
                   //sessionStorage['Batch.batchId']=data['batchId'];
                  sessionStorage['branchId']= (data['branchId']);
                   //sessionStorage['passingYear']=data['batch'].passingYear;

                   console.log("*****************STUDENT***********");
                   this.toastr.success("Student Login Successfully!!!");
                    this.router.navigate(['/student'+ "/"+data['id']]);
              }else if(data['role']=="ALUMNI"){
                sessionStorage['firstName']=data['firstName'];
                   sessionStorage['lastName']=data['lastName'];
                   sessionStorage['id']=data['id'];
                   sessionStorage['address']=data['address'];
                   sessionStorage['cityId']=data['cityId'];
                   sessionStorage['stateId']=data['stateId'];
                   sessionStorage['countryId']=data['countryId'];
                   sessionStorage['email']=data['email'];
                   //sessionStorage['Batch.batchId']=data['batchId'];
                   sessionStorage['branchId']= (data['branchId']);
                   //sessionStorage['passingYear']=data['batch'].passingYear;
                console.log("*****************Alumni***********");
                this.toastr.success("Alumni Login Successfully!!!");
                 this.router.navigate(['/alumni'+"/"+data['id']]);
              }
              else{
                this.toastr.success("Admin Login  Successfully!!!");
                     this.router.navigate(['/admin']);
               }
         }
         else{
          this.router.navigate(['/home']);
         }  
      },
      error => {
        this.toastr.error("Login Failed,Please Enter valid User name and Password!!!");
      });
    }
  }
      
    
     
/*
        if(this.email=="pranoti@gmail.com" && this.password=="admin")
        {
          this.router.navigate(['/admin']);
        }
        else if(this.email=="student@gmail.com" && this.password=="student"){
          this.router.navigate(['/student']);
        }
        */
     
    
  

