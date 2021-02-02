export class Job{

    id:number;
    jobId:number;
    title:string;
    description:string;
    link:string;
    startDate:Date;
    endDate:Date;

    constructor(id:number,jobId:number,title:string,description:string,link:string,startDate:Date,endDate:Date){
        this.jobId=jobId;
        this.title=title;
        this.description=description;
        this.link=link;
        this.startDate=startDate;
        this.endDate=endDate;
    }
}