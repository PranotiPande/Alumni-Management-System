import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
9
import { Admin } from '../../models/admin.model';
import { Batch } from '../../models/batch.model';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  aarr:Admin[];
  ob:Admin;
  barr:Batch[];
  

  constructor(private adminservice:AdminService,private router:Router) {  }

  ngOnInit() {
    this.adminservice.getAdminDetails()
    .subscribe(result=>{console.log(result);
    this.aarr=result});
  }

  /*viewAllBatches(){

    this.adminservice.getAllBatches().subscribe(r=>{
      console.log(r);
      this.barr=r;
      this.router.navigate(['/batch']);
    });

  }*/

  logout(){
    sessionStorage.removeItem("id");
    sessionStorage.removeItem("firstName");
    sessionStorage.removeItem("lastName");
    sessionStorage.removeItem("address");
    sessionStorage.removeItem("cityId");
    sessionStorage.removeItem("stateId");
    sessionStorage.removeItem("branchId");
    sessionStorage.removeItem("batchId");
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("countryId");
    sessionStorage.removeItem("alumniId");
    this.router.navigate(["/login"]);
  }

}
