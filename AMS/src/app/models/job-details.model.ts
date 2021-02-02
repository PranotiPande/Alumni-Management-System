import { ThisReceiver } from '@angular/compiler';

export class JobDetails{

    alumniJobId:number;
    companyName:string;
    designation:string;
    joinDate:Date;
   leavingDate:Date;
   constructor(alumniJobId:number,companyName:string,designation:string,
    joinDate:Date,leavingDate:Date)
    {
       this.alumniJobId=alumniJobId;
       this.companyName=companyName;
       this.designation=designation;
       this.joinDate=joinDate;
       this.leavingDate=leavingDate; 
    }
}