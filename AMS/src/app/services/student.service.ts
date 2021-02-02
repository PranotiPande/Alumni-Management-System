import { Injectable } from '@angular/core';
import {Student} from "../models/student.model";
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Router , ActivatedRoute} from '@angular/router';
import { Observable, Subject } from 'rxjs';
import {map} from 'rxjs/operators';


@Injectable()
export class StudentService{
    parr:Student[];
    obj:Student;
    status:boolean;
     subject = new Subject<Student[]> ();
    
    private baseurl="http://localhost:8080/students";
    //add ActivatedRout obj 
    constructor(private httpC:HttpClient,private router:Router,private route:ActivatedRoute){

    }

    getAllStudent():Observable<Student[]>{
        return this.httpC.get<Student[]>(this.baseurl)
       
    }


    addStudentdetails(s:Student):Observable<Student[]>{
        var subject=new Subject<Student[]>();
        this.httpC.post<Student>(this.baseurl,s).subscribe(r=>{
       console.log("student added");
       console.log(r);
        });
        return subject.asObservable();
    }

    getStudentDetailById(any):Observable<Student[]>{
     
      var subject=new Subject<Student[]>();
    this.httpC.get(this.baseurl+"/"+any).subscribe(
            result=>{
                console.log("*######*");
                console.log(result);
                //return result;
                //this.subject=result as Subject<Student[]>;
                 });
                // console.log("***subject******")
                 //console.log(subject.asObservable())
                return subject.asObservable();
        
    }
  /* getStudentDetailById(any):Observable<Student[]>{
        var subject=new Subject<any>();
        this.httpC.get(this.baseurl+"/"+any).pipe(map((response)=>
            {
                console.log("$$$$$$$$")
                console.log(response);
                return response;
            })
        );
        return subject.asObservable();
        }*/

     
    authenticateStudent(any):Observable<Student[]>{
        var subject=new Subject<Student[]>();
        this.httpC.post<Student>(this.baseurl+"/login",any).subscribe(r=>{   
        console.log(r);
    });
        return subject.asObservable();
    }


    uploadFile(selectedFile: File,user:Student) {
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


      getAllStudentsByRole():Observable<Student[]>{
        return this.httpC.get<Student[]>(this.baseurl+"/student");
       
    }
    getAllAluminByRole():Observable<Student[]>{
      return this.httpC.get<Student[]>(this.baseurl+"/alumni");
     
  }
  
  deleteUser(p:Student):Observable<Student[]>{
    var subject=new Subject<Student[]>();
     this.httpC.delete(this.baseurl+"/"+p.id).subscribe(r=>{
          console.log("deleted");
          console.log(r);
          this.httpC.get<Student[]>(this.baseurl).subscribe(result=>{
          subject.next(result);

         });
     });
     return subject.asObservable();


  }

}