export class Feedback{

    feedbackId:number;
    id:number;
    description:string;
    feedbackDate:Date;


    constructor( feedbackId:number,
        id:number,description:string,feedbackDate:Date)
    {
        this.feedbackId=feedbackId;
        this.id=id;
        this.description=description;
        this.feedbackDate=feedbackDate;
    }
}