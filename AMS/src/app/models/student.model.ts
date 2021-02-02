export class Student{
   /* id:number;
    dob:Date;
    address:string;
    contactNo:string;
    email:string;
    firstName:string;
    gender:number;
    lastName:string;
    password:string;
    role:string;
    batchId:number;
    branchId:number;
    countryId:number;
    stateId:number;
    cityId:number;
*/
    /*constructor(id:number,dob:Date,address:string, contactNo:string, email:string,firstName:string,gender:number,
        lastName:string, password:string,role:string, batchId:number,branchId:number,cityId:number,countryId:number,stateId:number)
    {
        this.id=id;
        this.dob=dob;
        this.address=address;
        this.contactNo=contactNo;
        this.email=email;
        this.firstName=firstName;
        this.gender=gender;
        this.lastName=lastName;
        this.password=password;
        this.role=role;
        this.batchId=batchId;
        this.countryId=countryId;
        this.stateId=stateId;
        this.branchId=branchId;
        this.cityId=cityId;

    }*/
    constructor(public id:number,public dob:string,public address:string, public contactNo:string, public email:string, public firstName:string,public gender:number,
        public lastName:string, public password:string,public role:string, public batchId:number,public branchId:number,public cityId:number,public countryId:number,public stateId:number)
{}
}