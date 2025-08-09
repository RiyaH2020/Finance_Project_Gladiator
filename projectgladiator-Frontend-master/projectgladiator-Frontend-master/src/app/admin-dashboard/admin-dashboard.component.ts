import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';


@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  users : Array<RegisteredUsers>;
  //adminId : number;
  Id : number;
  cardType: String;
  message : String;
  dash:adminDashboard=new adminDashboard();

  constructor(private userService:UserService,private router:Router) { }

  
  
  ngOnInit() {
    this.dash.adminId=parseInt(sessionStorage.getItem('adId'));
    // let aid = sessionStorage.getItem('adId');
    console.log(this.dash.adminId);
    this.userService.getAllUsers(this.dash.adminId).subscribe(response=>{
      // alert(JSON.stringify(response));
      this.users=response;

    })
  }


  setStatus(event,userId,username,cardType){
    sessionStorage.setItem("userId",userId);
    sessionStorage.setItem("username",username);
    sessionStorage.setItem("cardType",cardType);
    this.router.navigate(['adminConfirmation']);
    
    
  }
}


export class RegisteredUsers
{
  userId : number;
  name : String;
  phoneNumber : number;
  email : String;
  username : String;
  password : String;
  address : String;
  cardType : String;
  bankName : String;
  accountNumber : number;
  ifsc : String;
  document : String;
  status : String;

}

export class adminDashboard{
  adminId:number;
}
