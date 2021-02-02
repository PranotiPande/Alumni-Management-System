import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,Subject } from 'rxjs';
import { Batch } from '../models/batch.model';

@Injectable({
  providedIn: 'root'
})
export class BatchService {
  arr:Batch[];

  private baseUrl="http://localhost:8080/batches";
  constructor(private httpC:HttpClient) { }

  getAllBatches():Observable<Batch[]>{
    return this.httpC.get<Batch[]>(this.baseUrl);
  }

  addBatchDetails(b:Batch):Observable<Batch[]>{
    var subject = new Subject<Batch[]> ();
        this.httpC.post<Batch>(this.baseUrl,b).subscribe(r=>{
       console.log("Batch added suceessfully.");
       console.log(r);
        });
        return subject.asObservable();
  }

  updateBatch(ob:Batch):Observable<Batch[]>{
    var subject=new Subject<Batch[]>();
    this.httpC.put(this.baseUrl+"/"+ob.batchId,ob).subscribe(
      result=>{
        console.log("from batch Services!!!!!!!!");
        console.log(ob);
        this.httpC.get<Batch[]>(this.baseUrl).subscribe(
          result=>{ subject.next(result);
          });
      });
      return subject.asObservable();
  }

}
