import { Component, OnInit,Input,Output,EventEmitter, SimpleChanges} from '@angular/core';
import { EventService } from "../../services/event.service";
import { Event } from "../../models/event.model";

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})

export class EventFormComponent {
  eventId:number;
  eventTitle:string;
  eventDescription:string;
  arr:Event[];
  @Input("uob") bob:Event;
  @Output() myevent = new EventEmitter();
  
  constructor(private eventservice:EventService) { }

 ngOnChanges(simple:SimpleChanges){
   console.log("in EVent On CHanges");
   if(simple["bob"].currentValue!=simple["bob"].previousValue){
     console.log(simple);
     this.eventId=simple["bob"].currentValue.eventId;
     this.eventTitle=simple["bob"].currentValue.eventTitle;
     this.eventDescription=simple["bob"].currentValue.eventDescription;
   }
  }
  AddEvent(){
    let e=new Event(this.eventId,this.eventTitle,this.eventDescription);
    console.log("***In Event form Add***");
    console.log(e);
    this.eventservice.addEvent(e).subscribe(r=>{
     console.log(r);
     
    });
  }

  UpdateEvent(){
    let e=new Event(this.eventId,this.eventTitle,this.eventDescription);
    console.log(e);
    this.eventservice.updateEvent(e).subscribe(r=>{
      console.log("Updated ");
      this.myevent.emit(r);
    });
    
    
    
  }

}
