import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import {Alumni} from "../../models/alumni.model";
import { AlumniService } from '../../services/alumni.service';
import {CityService} from '../../services/city.service';
import {BranchService} from '../../services/branch.service';
import {Branch} from '../../models/branch.model';
import {City} from '../../models/city.model';
import {JobDetails} from '../../models/job-details.model';
import { JobDetailService } from 'src/app/services/job-details.service';
import {EventService} from '../../services/event.service';
import {Event} from '../../models/event.model';


@Component({
  selector: 'app-alumni',
  templateUrl: './alumni.component.html',
  styleUrls: ['./alumni.component.css']
})
export class AlumniComponent implements OnInit {
  parr:Alumni[];
  ob:Alumni;
  selectedFile: File = null;
  retrievedImage: any;
  message: string = null;
  city:any;
  branch:any;
  jobdetails:any;
  flag:boolean=false;
  eventarr:Event[];
  alumni:any;
  
  
id=sessionStorage.getItem('id');
//firstName=sessionStorage.getItem('firstName');
//lastName=sessionStorage.getItem('lastName');
//address=sessionStorage.getItem('address');
cityId=sessionStorage.getItem('cityId');
//stateId=sessionStorage.getItem('stateId');
//countryId=sessionStorage.getItem('countryId');
//email=sessionStorage.getItem('email');
//passingYear=sessionStorage.getItem('passingYear');
branchId=sessionStorage.getItem('branchId');




  constructor(private alumniservice:AlumniService,
    private cityservice:CityService,
    private branchservice:BranchService,
    private jobdetailservice:JobDetailService,
    private Eventservice:EventService,
    private router:Router,
    private route:ActivatedRoute,
   ) { }

  ngOnInit(){
    /*this.studentservice.getStudentDetailById(this.id).subscribe((result)=>
    {
      console.log("@@!!!!!!@@");
     console.log(result);
     this.parr=result;
    },
    (error)=>{
      console.log(error);
    });
  }*/
  let id=parseInt(this.id)
  
  this.alumniservice.getStudentDetailById(id).subscribe(
    resp=>{
      console.log(resp);
    this.alumni=resp; 
    }
    
  )
    this.alumniservice.retrieveImage(id).subscribe(
      resp => {
        console.log(resp);//resp is of type ImageEntity
        this.retrievedImage = `data:${resp.type};base64,${resp.data}`;
      },
      error => {
        console.log(error);
        if (error.status === 404)
          this.message = "Image Not Found!!!!";
        else
          this.message = `Server Error :${error.message}`;
          this.retrievedImage=null;
      }
    );
 
   /* this.route.paramMap.subscribe(params=>{
     const id=params.get('id');
     

   this.studentservice.getStudentDetailById(id).subscribe((result)=>
   {
     console.log("@@!!!!!!@@");
    console.log(result);
    this.parr=result;
   },
   (error)=>{
     console.log(error);
   });
});*/

let cityId=parseInt(this.cityId)

this.cityservice.getCity(cityId).subscribe(
  resp=>{
    console.log(resp);
    this.city=resp;
  }
)

let branchId=parseInt(this.branchId)
this.branchservice.getBranch(branchId).subscribe(
  resp=>{
    console.log(resp);
    this.branch=resp;
  }
)

let ID1 =parseInt(this.id)
this.jobdetailservice.getAllJobDetailsByUserID(ID1).subscribe(
  resp=>{
    console.log("job details"+resp);
    this.jobdetails=resp;
  }
)

  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }
  onUpload() {
    this.alumniservice.uploadFile(this.selectedFile,this.ob).subscribe(
      resp => {
        console.log(resp);
       
      }
    );
  }
  viewEvents(){

    this.flag=true;
    this.Eventservice.getAllEvents().subscribe(
      resp=>{
        console.log(resp);
        this.eventarr=resp;
      }
    )

  }

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
