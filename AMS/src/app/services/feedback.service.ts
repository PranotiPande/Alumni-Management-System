import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,Subject } from 'rxjs';
import {Feedback} from '../models/feedback.model';

@Injectable({
    providedIn: 'root'  
})

export class FeedbackService{

feedbackarr:Feedback[];
private baseUrl="http://localhost:8080/feedback";

constructor(private httpC:HttpClient){

}
getAllFeedBackDetails():Observable<Feedback[]>{
    return this.httpC.get<Feedback[]>(this.baseUrl);
}

addFeedBack(f:Feedback):Observable<Feedback[]>{
 var subject=new Subject<Feedback[]>();
 this.httpC.post<Feedback>(this.baseUrl,f).subscribe(
     resp=>{
     console.log(resp);
});

return subject.asObservable();
}
}