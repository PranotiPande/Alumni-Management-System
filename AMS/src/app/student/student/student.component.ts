
import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import {Student} from "../../models/student.model";
import { StudentService } from '../../services/student.service';
import {CityService} from '../../services/city.service';
import {BranchService} from '../../services/branch.service';
import { City } from 'src/app/models/city.model';
import {EventService} from '../../services/event.service';
import{Event} from '../../models/event.model';
import {JobService} from '../../services/Job.service';
import {Job} from '../../models/job.model';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {

 parr:Student[];
  ob:Student;
  selectedFile: File = null;
  retrievedImage: any;
  message: string = null;
  city:any;
  branch:any;
  eventarr:Event[];
  flag:boolean=false;
  aflag:boolean=false;
  jflag:boolean=false;
  jobarr:Job[];
  
id=sessionStorage.getItem('id');
firstName=sessionStorage.getItem('firstName');
lastName=sessionStorage.getItem('lastName');
address=sessionStorage.getItem('address');
cityId=sessionStorage.getItem('cityId');
stateId=sessionStorage.getItem('stateId');
countryId=sessionStorage.getItem('countryId');
email=sessionStorage.getItem('email');
branchId=sessionStorage.getItem('branchId')
//passingYear=sessionStorage.getItem('passingYear');
//branchName=sessionStorage.getItem('branchName');


cityname=sessionStorage.getItem('cityName');

  constructor(private studentservice:StudentService,
    private cityservice:CityService,
    private branchservice:BranchService,
    private Eventservice:EventService,
    private jobservice:JobService,
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
  let ID=parseInt(this.id)
  
    this.studentservice.retrieveImage(ID).subscribe(
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
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }
  onUpload() {
    this.studentservice.uploadFile(this.selectedFile,this.ob).subscribe(
      resp => {
        console.log(resp);
       
      }
    );
  }

  viewEvents(){

    this.flag=true;
    this.aflag=false;
    this.jflag=false;
    this.Eventservice.getAllEvents().subscribe(
      resp=>{
        console.log(resp);
        this.eventarr=resp;
      }
    )

  }

 /* onlogout(){
    sessionStorage.removeItem['firstName'];
    this.router.navigate('/home');
  }
  */

 viewAlumniProfile()
 {
   this.aflag=true;

  this.flag=false;
  this.jflag=false;
  
 }
 viewjobOpenings(){
  this.jflag=true;
   this.aflag=false;
   this.flag=false;
   //this.router.navigate(['/jobopen'])
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