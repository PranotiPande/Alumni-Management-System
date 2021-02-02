import { Injectable } from '@angular/core';
import {Login} from "../models/login.model";
import {HttpClient} from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

@Injectable()
export class LoginService{
    parr:Login[];
    private baseurl="http://localhost:8080/students/login";
    constructor(private httpC:HttpClient)
    {

    }
    /*authenticateStudent(l:Login):Observable<Login[]>{
        var subject=new Subject<Login[]>();
        this.httpC.post<Login>(this.baseurl,l).subscribe(r=>{   
        });
        return subject.asObservable();

    }*/
    authenticateStudent(email:string,password:string)
  {
    console.log("in login service");
    const body={
      email:email,
      password:password
    }
    return this.httpC.post(this.baseurl,body);
  }
}