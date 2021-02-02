import { Component, OnInit } from '@angular/core';
import {JobService} from '../../services/Job.service';
import {Job} from '../../models/job.model';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {
 
jobarr:Job[];
jobob:Job;
id:number;
jobId:number;
title:string;
description:string;
link:string;
startDate:Date;
endDate:Date;
ID=sessionStorage.getItem('id');

  constructor(private jobservice:JobService) { }

  ngOnInit(){}
  postJobOpenings(){
    let job=new Job(this.id,this.jobId,this.title,this.description,this.link,this.startDate,this.endDate)
    this.jobservice.addJobDetails(job).subscribe(
      resp=>{
        console.log(resp);
      }
    )
  }
}