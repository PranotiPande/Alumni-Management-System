import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {StudentService} from '../../services/student.service';
import {Student} from '../../models/student.model';
import { Router,ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
id:number;
lastName:string;
email:string;
password:string;
address:string;
countryId:number;
stateId:number;
cityId:number;
gender:number;
dob:string;
contactNo:string;
branchId:number;
batchId:number;
role:string;
name:string;
selectedFile: File = null;
ob:Student;
//user : Student=new Student(0,new Date(),"","","","",0,"","","",0,0,0,0,0);
@Input("sob") stud:Student;
@Output() myevent=new EventEmitter();
  constructor(private studentservice:StudentService,private router:Router,
    private route:ActivatedRoute,private toastr:ToastrService) { }

  ngOnInit(): void {
  }

 /* addstudentdeatils(){
    
    let s=new Student(this.id,this.dob,this.address,this.contactNo,this.email,this.name,this.gender,this.lastName,this.password,this.role,this.batchId,this.branchId,this.countryId,this.stateId,this.cityId)
    console.log("registration done successfully");
    console.log("***********");
    console.log(s);
    this.studentservice.addStudentdetails(s)
    .subscribe(r=>{console.log(r);
    this.myevent.emit(r);
    });

    
  }*/


   //event handler function : called when the file input changes
   public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }
  //event handler function called when Upload btn is clicked
  onUpload() {
    if(this.address==null){
      this.toastr.warning("Address is mandatory!!!");
    }
    else if(this.dob==null){
      this.toastr.warning("Date Of Birth is mandatory!!!");
    }
    else if(this.contactNo==null){
      this.toastr.warning("Contact number is mandatory!!!");
    }
    else if(this.email==null){
      this.toastr.warning("Email is mandatory!!!");
    }
    else if(this.name==null){
      this.toastr.warning("Name is mandatory!!!");
    }
    else if(this.gender==null){
      this.toastr.warning("gender is mandatory!!!");
    }
    else if(this.lastName==null){
      this.toastr.warning("last name is mandatory!!!");
    }
    else if(this.password==null){
      this.toastr.warning("password is mandatory!!!");
    }
    else if(this.role==null){
      this.toastr.warning("role is mandatory!!!");
    }
    else if(this.batchId==null){
      this.toastr.warning("please select Batch!!!");
    }
    else if(this.branchId==null){
      this.toastr.warning("Please select branch!!!");
    }
    else if(this.countryId==null){
      this.toastr.warning("Please select country!!!");
    }
    else if(this.stateId==null){
      this.toastr.warning("Please select state!!!");
    }
    else if(this.cityId==null){
      this.toastr.warning("Please select city!!!");
    }
    else{
    let s=new Student(this.id,this.dob,this.address,this.contactNo,this.email,this.name,this.gender,this.lastName,this.password,this.role,this.batchId,this.branchId,this.countryId,this.stateId,this.cityId)
    console.log("on upload***")
    this.studentservice.uploadFile(this.selectedFile,s).subscribe(
      resp => {
        console.log(resp);
       
      }
    );
    this.toastr.success("Registration done SuccessFully!!!");
    this.router.navigate(["/login"]);
  }
}

}
