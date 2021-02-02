import { Component, OnInit } from '@angular/core';
import { Batch } from '../../models/batch.model';
import { BatchService } from "../../services/batch.service";

@Component({
  selector: 'app-batch',
  templateUrl: './batch.component.html',
  styleUrls: ['./batch.component.css']
})
export class BatchComponent implements OnInit {
  arr:Batch[];
  ob:Batch;

  constructor(private Batchservice:BatchService) { }

  ngOnInit(): void {
    this.Batchservice.getAllBatches()
    .subscribe(result=>{
      console.log(result);
      this.arr=result});
  }

  updateBatch(b:Batch){
    console.log("****In Batch Update****");
    this.ob=b;    
  }

}
