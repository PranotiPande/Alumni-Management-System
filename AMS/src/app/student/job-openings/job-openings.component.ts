import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import {JobService} from '../../services/Job.service';
import {Job} from '../../models/job.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-job-openings',
  templateUrl: './job-openings.component.html',
  styleUrls: ['./job-openings.component.css'],
  providers: [DatePipe]
})
export class JobOpeningsComponent implements OnInit {
  jobarr:Job[];
  obj:Job;
  flag:boolean=false;
  date=new Date();
Date=new Date();
  constructor(private router:Router,private route:ActivatedRoute,private datePipe: DatePipe,private jobservice:JobService) {
    var date = this.datePipe.transform(new Date(),"dd-MM-yyyy");
   }
 
  ngOnInit(): void {
    this.jobservice.getAllJobsDetails()
    .subscribe(result=>{
      console.log(result);
      this.jobarr=result;  
      let date = this.datePipe.transform(new Date(),"yyyy-MM-dd");
      console.log(date);
       
    });
   
  }
 

}
