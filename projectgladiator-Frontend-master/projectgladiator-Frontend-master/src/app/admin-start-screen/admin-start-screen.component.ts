import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-start-screen',
  templateUrl: './admin-start-screen.component.html',
  styleUrls: ['./admin-start-screen.component.css']
})
export class AdminStartScreenComponent implements OnInit {


  count: number;
  adminId:number;

  constructor(private userService: UserService,private router:Router) { }

  
  ngOnInit() {
    
    this.adminId=parseInt(sessionStorage.getItem("adId"));
    this.userService.getPendingCount(this.adminId).subscribe(response =>{
      this.count= response;
    })
  }

    logoutFunction(){
      sessionStorage.clear();
      console.log(sessionStorage.getItem("adId"));
      this.router.navigate(['index']);
    }
  
  


}
