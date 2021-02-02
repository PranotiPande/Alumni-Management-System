import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Job } from "../models/job.model";

@Injectable({
  providedIn: 'root'
})
export class JobService {
  jobarr:Job[];
  private baseUrl="http://localhost:8080/job";


  constructor(private httpC:HttpClient) { }

  getAllJobsDetails():Observable<Job[]>{
    return this.httpC.get<Job[]>(this.baseUrl);
  }

  addJobDetails(j:Job):Observable<Job[]>{
    var subject=new Subject<Job[]>();
    this.httpC.post<Event>(this.baseUrl,j).subscribe(r=>{
      console.log("Job Added.");
      console.log(r);
    });
    return subject.asObservable();
  }

}