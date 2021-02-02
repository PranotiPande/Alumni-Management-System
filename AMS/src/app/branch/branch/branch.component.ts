import { Component, EventEmitter,Input, OnInit, Output,SimpleChanges} from '@angular/core';
import { Branch } from 'src/app/models/branch.model';
import { BranchService } from 'src/app/services/branch.service';
import {BranchFormComponent} from '../branch-form/branch-form.component';


@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css']
})
export class BranchComponent implements OnInit {
  arr:Branch[];
  ob:Branch;
  flag:boolean=false;
  branchId:number;
  branchName:string;
  @Input("uob") bob:Branch; 
  @Output() myevent=new EventEmitter();

  constructor(private branchService:BranchService) {
  

   }
   ngOnInit() {
    this.branchService.getAllBranches()
    .subscribe(result=>{
      console.log(result);
      this.arr=result});
  }
    
  /* ngOnChanges(simple:SimpleChanges){
    console.log("in ngOnChange");
    if(simple["Bob"].currentValue !=simple["Bob"].previousValue){
      console.log(simple);
      this.branchName=simple["Bob"].currentValue.branchName;
      this.branchId=simple["Bob"].currentValue.branchId;
    }

   }*/

 
 /* updateBranch(){
    let b=new Branch(this.branchId,this.branchName);
    console.log("*****in update branch from component ts******");
    console.log(b);
    this.branchService.updateBranch(b).subscribe(result=>{
     console.log("updated"); 
      this.myevent.emit(result);
    });*/

    updateBranch(b:Branch){
      this.flag=true;
      console.log("***in Branch update****");
      this.ob=b;
    }

    /*deleteBranch(b:Branch){

    }*/

    AddBranch(){
      this.flag=true;
    }

}

