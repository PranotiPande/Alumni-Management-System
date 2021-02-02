import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BatchComponent } from '../batch/batch/batch.component';
import { RouterModule, Routes } from '@angular/router';
import { BatchModule } from "../batch/batch.module";
import { AdminComponent } from '../admin/admin/admin.component';
import { BranchModule } from "../branch/branch.module";
import { BranchComponent } from '../branch/branch/branch.component';
import { EventComponent } from '../event/event/event.component';
import { EventModule } from '../event/event.module';
import{UserDtlsComponent} from '../student/user-dtls/user-dtls.component';
import { StudentModule } from '../student/student.module';
const routes:Routes=[
  
  {path:'',redirectTo:'home',pathMatch:'full'},  
  {path:'batch',component:BatchComponent},
  {path:'branch',component:BranchComponent},
  {path:'event',component:EventComponent},
  {path:'userdtls',component:UserDtlsComponent},
  

]

@NgModule({
  declarations: [
    AdminComponent
   
  ],

  imports: [
    BatchModule,
    BranchModule,
    EventModule,
    StudentModule,
    CommonModule,
    RouterModule.forRoot(routes)
  ],

  exports:[
    AdminComponent
  ]
})
export class AdminModule { }
