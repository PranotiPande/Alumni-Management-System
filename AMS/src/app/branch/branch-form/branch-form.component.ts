import { Component, OnInit,Input,Output,EventEmitter, SimpleChanges} from '@angular/core';
import {BranchService} from '../../services/branch.service';
import {Branch} from "../../models/branch.model";
@Component({
  selector: 'app-branch-form',
  templateUrl: './branch-form.component.html',
  styleUrls: ['./branch-form.component.css']
})
export class BranchFormComponent  {
  branchId:number;
  branchName:string;
  arr:Branch[];
  @Input("uob") bob:Branch; 
  @Output() myevent=new EventEmitter();
  constructor(private branchservice:BranchService) { }

  ngOnChanges(simple:SimpleChanges){
    console.log("in ngOnChange");
    if(simple["bob"].currentValue!=simple["bob"].previousValue){
      console.log(simple);
      this.branchId=simple["bob"].currentValue.branchId;
      this.branchName=simple["bob"].currentValue.branchName;
    }
  }
  UpdateBranch(){
    let b=new Branch(this.branchId,this.branchName);
    console.log(b);
    this.branchservice.updateBranch(b).subscribe(result=>{
      console.log("updated");
      this.myevent.emit(result);
      this.branchId=0;
    });
      this.branchName="";
  }

  AddBranch(){
    let b=new Branch(this.branchId,this.branchName);
    console.log("********in Branch form add******");
    console.log(b);
    this.branchservice.addBranch(b)
    .subscribe(r=>{console.log(r);
      this.myevent.emit(r);
    this.branchId=0;
      this.branchName="";
    });
  }
 
}
