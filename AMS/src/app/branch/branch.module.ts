import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BranchComponent } from './branch/branch.component';
import { FormsModule } from '@angular/forms';
import { BranchFormComponent } from './branch-form/branch-form.component';
//import { BranchFormComponent } from './branch-form.component';

@NgModule({
  declarations: [
    BranchComponent,
    BranchFormComponent,
    //BranchFormComponent
  ],
  imports: [
    FormsModule,
    CommonModule
  ],
  exports:[
    BranchComponent,
    //BranchFormComponent
  ]
})
export class BranchModule { }