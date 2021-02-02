import { Component, OnInit,Input,Output,EventEmitter, SimpleChanges} from '@angular/core';
import { BatchService } from "../../services/batch.service";
import {Batch} from "../../models/batch.model";

@Component({
  selector: 'app-batch-form',
  templateUrl: './batch-form.component.html',
  styleUrls: ['./batch-form.component.css']
})
export class BatchFormComponent {

  batchId:number;
  passingYear:number;
  arr:Batch[];
  @Input("uob") bob:Batch;
  @Output() myevent=new EventEmitter();

  constructor(private batchservice:BatchService) { }

  ngOnChanges(simple:SimpleChanges) {
    console.log("in Batch onChnages");
    if(simple["bob"].currentValue!=simple["bob"].previousValue){
     console.log(simple);
      this.batchId=simple["bob"].currentValue.batchId;
      this.passingYear=simple["bob"].currentValue.passingYear;
    }    
  }
  UpdateBatch(){
    let b=new Batch(this.batchId,this.passingYear);
    console.log(b);
    this.batchservice.updateBatch(b).subscribe(result=>{
      console.log("updated");
      this.myevent.emit(result);
    }); 
  }

  AddBatch(){
    let b=new Batch(this.batchId,this.passingYear);
    console.log("*******in batch form add***********");
   console.log(b);
    this.batchservice.addBatchDetails(b)
    .subscribe(r=>{
     console.log(r);
      });    
  }

}
