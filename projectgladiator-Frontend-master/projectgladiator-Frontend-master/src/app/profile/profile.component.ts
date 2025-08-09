import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisteredUsers } from '../admin-dashboard/admin-dashboard.component';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  updateUser : UpdateUser = new UpdateUser();
  registeredUser : RegisteredUsers = new RegisteredUsers();
  username : string;
  submitted = false;
  password = false;
  confirmPassword:String;
  isApproved:boolean;

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit() {
    this.isApproved=((sessionStorage.getItem("approved"))=="true");
    this.username = sessionStorage.getItem("uname");
    this.userService.getProfile(this.username).subscribe(response=>{
      this.registeredUser=response;
      this.initializeUser(this.registeredUser);
    })
  }

  initializeUser(registeredUser:RegisteredUsers){
    this.updateUser.oldUserName=registeredUser.username;
    this.updateUser.newUserName=registeredUser.username;
    this.updateUser.name=registeredUser.name;
    this.updateUser.phoneNumber=registeredUser.phoneNumber;
    this.updateUser.email=registeredUser.email;
    this.updateUser.address=registeredUser.address;
    this.updateUser.bankName=registeredUser.bankName;
    this.updateUser.accountNumber=registeredUser.accountNumber;
    this.updateUser.ifsc=registeredUser.ifsc; 
    this.updateUser.password=registeredUser.password;
    this.confirmPassword=registeredUser.password;   
  }

  update(){
    if(JSON.stringify(this.updateUser.password)!=JSON.stringify(this.confirmPassword)){
      console.log(this.updateUser.password+" confirm:"+this.confirmPassword);
      alert("Password doesnot match");
    }
    else{
      this.userService.updateProfile(this.updateUser).subscribe(response=>{
      alert(response.message);
      if(response.status==="SUCCESS"){
        sessionStorage.setItem("uname",response.username);
      }
      })
    }
  }

  showPassword(){
    if(this.password==true){
    this.password=false;
    }
   else{
     this.password=true;
   } 
  }
}


export class UpdateUser{
  oldUserName:String;
  newUserName:String;
  name:String;
  phoneNumber:number;
  email:String;
  address:String;
  bankName:String;
  accountNumber:number;
  ifsc:String;
  password:String;
}
