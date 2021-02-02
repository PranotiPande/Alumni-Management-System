export class Event{

    eventId:number;
    eventTitle:string;
    eventDescription:string;

    constructor(eventId:number,eventTitle:string,eventDescription:string){
        this.eventId=eventId;
        this.eventTitle=eventTitle;
        this.eventDescription=eventDescription;
    }
}