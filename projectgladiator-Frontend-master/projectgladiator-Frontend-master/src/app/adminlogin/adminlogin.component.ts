import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../1. finance/finance.Classes';
import { UserService } from '../user.service';


@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  login: Login = new Login(); 
  constructor(private userService: UserService, private router: Router ) { }
  message: string;

  ngOnInit(): void {
    if(sessionStorage.getItem('adId')!=null){
      this.router.navigate(['admin-start-screen']);
    }
  }

  checkLogin(){
    this.userService.adminLogin(this.login).subscribe(response=>{
      console.log(response);
      if(response.status == "SUCCESS"){
        console.log("success");
        this.message="";
        let adminId = response.adminId;
        sessionStorage.setItem('adId', adminId);
        // console.log(sessionStorage.getItem('adId'));
        this.router.navigate(['admin-start-screen']);
      }
      else
      this.message = response.message; 
    })
  }

}
