import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Branch } from "../models/branch.model";

@Injectable({
  providedIn: 'root'
})
export class BranchService {
  arr:Branch[];
 
 private baseUrl="http://localhost:8080/branches";
  constructor(private httpC:HttpClient) { }

  getAllBranches():Observable<Branch[]>{
    return this.httpC.get<Branch[]>(this.baseUrl);
  }

  addBranch(b:Branch):Observable<Branch[]>{
    var subject =new Subject<Branch[]>();
    this.httpC.post<Branch>(this.baseUrl,b).subscribe(r=>{
      console.log("*******Branch Added******");
      console.log(r);
      this.httpC.get<Branch[]>(this.baseUrl).subscribe((r)=>{
console.log("***In service branch add function*****");
console.log(r);
        subject.next(r);
      });
    });
    return subject.asObservable();
  }

  updateBranch(ob:Branch):Observable<Branch[]>{

    var subject=new Subject<Branch[]>();
    this.httpC.put(this.baseUrl+"/"+ob.branchId,ob).subscribe(
      result=>{
        console.log("from branch Services!!!!!!!!");
        console.log(ob);
        this.httpC.get<Branch[]>(this.baseUrl).subscribe(
          result=>{ subject.next(result);
          });
      });
      return subject.asObservable();  
    }


    getBranch(branchId:number)
    {
        console.log(this.baseUrl+"/"+branchId)
      return this.httpC.get(this.baseUrl+"/"+branchId); 
    }
    
    
    





  }


