import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { JobDetailsComponent } from '../job-details/job-details/job-details.component';
import {JobDetails} from "../models/job-details.model";

@Injectable({
    providedIn: 'root'
  })
export class JobDetailService{
    arr:JobDetails[];
    private baseUrl="http://localhost:8080/alumnijobdetails";
    constructor(private httpC:HttpClient) { }

    getAllJobdetails():Observable<JobDetails[]>{
        return this.httpC.get<JobDetails[]>(this.baseUrl);
    }



    getAllJobDetailsByUserID(ID:number)
    {
        console.log(this.baseUrl+"/"+ID)
      return this.httpC.get(this.baseUrl+"/"+ID); 
    }

    addAlumniJobDetails(job:JobDetails):Observable<JobDetails[]>{
      var subject=new Subject<JobDetails[]>();
      this.httpC.post<JobDetails>(this.baseUrl,job).subscribe(r=>{
     console.log("job added successfully!!!!");
     console.log(r);
      });
      return subject.asObservable();
  }


}