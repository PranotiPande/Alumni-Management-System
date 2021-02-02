import { Component, OnInit ,Input} from '@angular/core';
import{JobDetailService} from '../../services/job-details.service';
import {JobDetails} from '../../models/job-details.model';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent implements OnInit {
  id=sessionStorage.getItem('id');
  alumniJobId:number;
  companyName:string;
  designation:string;
  joinDate :Date;
  leavingDate:Date;
  obj:JobDetails;
  @Input("job") j:JobDetails;
  constructor(private jobdetailsservice:JobDetailService, private router:Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {

  }
  
  addjobDetails(){
let job=new JobDetails(this.alumniJobId,this.companyName,this.designation,this.joinDate,this.leavingDate)
console.log("In add job detials method");

this.jobdetailsservice.addAlumniJobDetails(job).subscribe(
  resp=>{
    console.log(resp);

  });
this.router.navigateByUrl("/alumni/"+this.id);
}

}
