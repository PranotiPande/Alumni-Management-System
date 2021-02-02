import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,Subject } from 'rxjs';
import { Event } from "../models/event.model";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  arr:Event[];

  private baseUrl="http://localhost:8080/events";///type here url

  constructor(private httpC:HttpClient) { }

  getAllEvents():Observable<Event[]>{
    return this.httpC.get<Event[]>(this.baseUrl);
  }

  addEvent(e:Event):Observable<Event[]>{
    var subject=new Subject<Event[]>();
    this.httpC.post<Event>(this.baseUrl,e).subscribe(r=>{
      console.log("Event Added.");
      console.log(r);
    });
    return subject.asObservable();
  }

  updateEvent(ob:Event):Observable<Event[]>{
    var subject=new Subject<Event[]>();
    this.httpC.put(this.baseUrl+"/"+ob.eventId,ob).subscribe(
      r=>{
        console.log("from event services");
        console.log(ob);
        this.httpC.get<Event[]>(this.baseUrl).subscribe(
          r=>{
            subject.next(r);
          });
      });
       return subject.asObservable();        
      
  }
}
