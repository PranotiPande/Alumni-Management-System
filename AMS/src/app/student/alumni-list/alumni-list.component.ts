import { Component, OnInit } from '@angular/core';
import {StudentService} from '../../services/student.service';
import {Alumni} from '../../models/alumni.model';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-alumni-list',
  templateUrl: './alumni-list.component.html',
  styleUrls: ['./alumni-list.component.css']
})
export class AlumniListComponent implements OnInit {
  alumniarr:Alumni[];
  alumniob:Alumni;
  id:number
  retrievedImage: any;
  message: string = null;

  constructor(private studentservice:StudentService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.studentservice.getAllAluminByRole().subscribe(
      resp=>{
        console.log(resp);
        this.alumniarr=resp;
      }
    )
    
  }
  viewprofile(id:number){
    sessionStorage.setItem('alumniId',id.toString());
    console.log("***in alumni-list***"+id)
    this.studentservice.retrieveImage(id).subscribe(
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

  }

}
