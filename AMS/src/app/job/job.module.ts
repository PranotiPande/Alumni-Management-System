import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobComponent } from './job/job.component';
import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from '@angular/router';
const routes:Routes=[
  {path:'job',component:JobComponent}
]
@NgModule({
  declarations: [JobComponent],
  imports: [
    FormsModule,
    CommonModule, 
    RouterModule.forRoot(routes)
  ],
  exports:[
    JobComponent
  ]
})
export class JobModule { }
