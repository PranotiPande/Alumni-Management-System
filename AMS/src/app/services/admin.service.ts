import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../models/admin.model';
import { Batch } from '../models/batch.model';
import { BatchService } from './batch.service';

@Injectable({
  providedIn: 'root'
})

export class AdminService {
  //arr:Admin[];

  private baseurl="http://localhost:8080/admin";//give base url localhost:8080/admin

  constructor(private httpC:HttpClient,private batchservice:BatchService) { }

  //write getAdmin etc methods
  getAdminDetails():Observable<Admin[]>{
    return this.httpC.get<Admin[]>(this.baseurl)
  }

  getAllBatches(){
    return this.httpC.get<Batch[]>(this.baseurl);
  }
}
