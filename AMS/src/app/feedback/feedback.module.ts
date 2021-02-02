import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeedbackComponent } from './feedback/feedback.component';
import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from '@angular/router';
import {DatePipe} from '@angular/common';

const routes:Routes=[
  {path:'feedback',component:FeedbackComponent}
]
@NgModule({
  declarations: [FeedbackComponent],
  imports: [ 
    FormsModule,
   CommonModule,
   RouterModule.forRoot(routes)
  ],
  providers:[
    DatePipe
  ],
  exports:[
   FeedbackComponent
  ]
})
export class FeedbackModule { }
