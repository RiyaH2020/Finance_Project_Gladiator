import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Register } from '../1. finance/finance.Classes';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent{

  
  register : Register = new Register();
  submitted=false;

  cardTypes = ['Gold','Platinum'];

  
  

  constructor(private userService: UserService,private router: Router) { }

  
  Register(){

   // this.submitted=true;  
    
    sessionStorage.setItem('uname',this.register.username);
    
    this.register.status="Pending For Approval";
    this.register.admin.adminId=1;
    
    this.userService.register(this.register).subscribe(response => {
      alert(JSON.stringify(response)); 
      this.router.navigate(['upload']);   
  })

 // alert(JSON.stringify(this.register));



}
}

