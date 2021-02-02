import { Component, OnInit } from '@angular/core';
import { EventService } from '../../services/event.service';
import { Event } from "../../models/event.model";

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  arr:Event[];
  ob:Event;

  constructor(private eventservie:EventService) { }

  ngOnInit() {
    this.eventservie.getAllEvents()
    .subscribe(result=>{
      console.log(result);
      this.arr=result});
  }
  updateEvent(e:Event){
    console.log("***In Event update");
    this.ob=e;
    
  }

}
