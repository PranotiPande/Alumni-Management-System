import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AlumniComponent } from './alumni/alumni.component';
import { AddJobComponent } from './add-job/add-job.component';
import { RouterModule, Routes } from '@angular/router';
import {FormsModule} from '@angular/forms';

const routes:Routes=[
  {path:'jobdeatils',component:AddJobComponent}


]

@NgModule({
  declarations: [AlumniComponent, AddJobComponent],
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[
    AlumniComponent
  ]
})
export class AlumniModule { }
