import { Component, OnInit,Input,Output} from '@angular/core';
import {FeedbackService} from '../../services/feedback.service';
import {Feedback} from '../../models/feedback.model';
import { DatePipe } from '@angular/common';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css'],
  providers: [DatePipe]
})
export class FeedbackComponent {
  feedbackId:number;
  id:number;
  description:string;
feedbackarr:Feedback[];
date=new Date();
Date=new Date();
ID=sessionStorage.getItem('id');
  constructor(private feedbackservice:FeedbackService,private datePipe: DatePipe,private router:Router,
    private route:ActivatedRoute) { 
  var date = this.datePipe.transform(new Date(),"dd-MM-yyyy");
    
  }

  ngOnInit(): void {

  }
  Addfeedback(){
  let date = this.datePipe.transform(new Date(),"dd-MM-yyyy");
    let f=new Feedback(this.feedbackId,this.id,this.description,this.date);
    console.log(f)
    this.feedbackservice.addFeedBack(f).subscribe(
      resp=>{
        console.log(resp);
      }
    );
   // this.router.navigateByUrl("/home");
  }
}
