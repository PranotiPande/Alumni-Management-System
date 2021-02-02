import { Injectable } from '@angular/core';
import {Alumni} from "../models/alumni.model";
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Router , ActivatedRoute} from '@angular/router';
import { Observable, Subject } from 'rxjs';
import {map} from 'rxjs/operators';


@Injectable()
export class AlumniService{
    parr:Alumni[];
    obj:Alumni;
    status:boolean;

    
    private baseurl="http://localhost:8080/students";
    //add ActivatedRout obj 
    constructor(private httpC:HttpClient,private router:Router,private route:ActivatedRoute){

    }

    getAllStudent():Observable<Alumni[]>{
        return this.httpC.get<Alumni[]>(this.baseurl)
       
    }


    addStudentdetails(s:Alumni):Observable<Alumni[]>{
        var subject=new Subject<Alumni[]>();
        this.httpC.post<Alumni>(this.baseurl,s).subscribe(r=>{
       console.log("student added");
       console.log(r);
        });
        return subject.asObservable();
    }

 getStudentDetailById(id:number)
 {
 return this.httpC.get(this.baseurl+"/"+id);
 }            
 
       

     
    authenticateStudent(any):Observable<Alumni[]>{
        var subject=new Subject<Alumni[]>();
        this.httpC.post<Alumni>(this.baseurl+"/login",any).subscribe(r=>{   
        console.log(r);
    });
        return subject.asObservable();
    }


    uploadFile(selectedFile: File,user:Alumni) {
        const uploadData = new FormData();
        uploadData.append("imageFile", selectedFile);
        console.log(`sending ${user}`);
        console.log(user);
      //  const userDtls=new UserDetails("madhura@gmail",27);
       // uploadData.append("dtls", "{'email' : 'rama@gmail.com','age' : 27}");
       uploadData.append("dtls",JSON.stringify(user));
       return this.httpC.post(this.baseurl+"/upload", uploadData, { responseType: 'text' });
      }
        

      retrieveImage(userId:number) {
        console.log("sending " + `${this.baseurl}/download/${userId}`);
        return this.httpC.get<any>(`${this.baseurl}/download/${userId}`);
    // return this.http.get<any>(`${this.baseURL}download/2`);
      }
}