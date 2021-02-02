export class Admin{
    adminId:number;
    userName:string;
    password:string;
    firstName:string;
    lastName:string;
    contactNo:string;

    constructor(adminId:number,userName:string, password:string,firstName:string,lastName:string,
        contactNo:string){
            this.adminId=adminId;
            this.userName=userName;
            this.password=password;
            this.firstName=firstName;
            this.lastName=lastName;
            this.contactNo=contactNo;
        }
}

