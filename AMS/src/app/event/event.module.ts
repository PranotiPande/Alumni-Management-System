import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventComponent } from './event/event.component';
import { FormsModule } from "@angular/forms";
import { EventFormComponent } from './event-form/event-form.component';


@NgModule({
  declarations: [
    EventComponent, 
    EventFormComponent
  ],
  imports: [
    FormsModule,
    CommonModule
  ],
  exports:[
    EventComponent
  ]
})
export class EventModule { }
