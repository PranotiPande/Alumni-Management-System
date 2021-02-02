import { Component, OnInit } from '@angular/core';
import {JobDetails} from '../../models/job-details.model';
import {JobDetailService} from '../../services/job-details.service';


@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {
arr:JobDetails[];
ob:JobDetails;
  constructor(private jobdetailservice:JobDetailService) { }

  ngOnInit(){
    this.jobdetailservice.getAllJobdetails()
    .subscribe(result=>{
      console.log(result);
      this.arr=result});
  }

}
