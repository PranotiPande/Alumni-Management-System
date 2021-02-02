import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,Subject } from 'rxjs';
import {City} from '../models/city.model';

@Injectable({
    providedIn: 'root'   
})

export class CityService{
    arr:City[]
    private baseUrl="http://localhost:8080/students/city";


    constructor(private httpC:HttpClient){}

    getCity(cityId:number)
    {
        console.log(this.baseUrl+"/"+cityId)
      return this.httpC.get(this.baseUrl+"/"+cityId); 
    }

}