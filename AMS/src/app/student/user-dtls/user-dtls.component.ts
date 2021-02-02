import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from 'src/app/models/student.model';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-user-dtls',
  templateUrl: './user-dtls.component.html',
  styleUrls: ['./user-dtls.component.css']
})
export class UserDtlsComponent implements OnInit {

  
  parr:Student[];
  alumniarr:Student[];
  studentarr:Student[];
  ob:Student;
  constructor(private studentservice:StudentService,private router:Router) { }

  ngOnInit(){
    this.studentservice.getAllStudent()
    .subscribe(result=>{console.log(result);
    this.parr=result});

    this.studentservice.getAllAluminByRole()
    .subscribe(res=>{console.log(res);
      this.alumniarr=res;
    });

    this.studentservice.getAllStudentsByRole()
    .subscribe(res=>{console.log(res);
      this.studentarr=res;
    });
    
  }

  updateStudentDetails(s:Student){
    console.log("***in Student update****");
    this.ob=s;
  }
  
  deleteUser(s : Student) {
    this.studentservice.deleteUser(s).subscribe(
      result=>{
        this.parr=result;
        console.log(s);
        
      }
    );
    //this.router.navigate([]);
    
  }
}
