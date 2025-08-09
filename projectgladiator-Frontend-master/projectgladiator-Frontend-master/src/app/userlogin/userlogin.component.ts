import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../1. finance/finance.Classes';
import { UserService } from '../user.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  login: Login = new Login();
  constructor(private userService: UserService, private router: Router) { }
  message: string;

  ngOnInit(): void {
    if(sessionStorage.getItem("uname")!=null){
      this.router.navigate(['dashboard'])
    }
  }

  checkLogin(){
    this.userService.login(this.login).subscribe(response=>{
      console.log(response);
      if(response.status == "SUCCESS" && response.docStatus=="UPLOADED"){
        console.log("success");
        this.message="";
        let username = response.name;
        sessionStorage.setItem('uname', username);
        sessionStorage.removeItem("cardnum");
        console.log(sessionStorage.getItem('uname'));
        this.router.navigate(['dashboard']);
        this.router.navigate(['admindashboard']);
        this.router.navigate(['dashboard']);
      }
      else if(response.status == "SUCCESS" && response.docStatus=="NOT_UPLOADED"){
        let username = response.name;
        sessionStorage.setItem('uname', username);
        alert(response.docStatus);
        this.router.navigate(['upload']);
      }
      else{
        this.message = response.message; 
      }
     
    })
  }
}
 