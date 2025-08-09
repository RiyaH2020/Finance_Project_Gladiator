import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDashService } from '../user-dash.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  dash:DashBoard=new DashBoard();
  card:Card=new Card();
  isApproved:boolean;
  isPending:boolean;
  isOverdue:boolean;
  daysLeft:number;
 
  constructor(private userdashService:UserDashService,private router:Router) 
  { }

  ngOnInit() {
    this.dash.username=sessionStorage.getItem('uname');
    this.userdashService.cardDash(this.dash).subscribe(response=>{
      if(response.status=='APPROVED')
      {
        this.card=response.card;
        this.isApproved=true;
        sessionStorage.setItem("approved",String(this.isApproved));
        sessionStorage.setItem("cardnum",this.card.cardNumber+"");
      }
      else{
        this.isApproved=false;
        sessionStorage.setItem("approved",String(this.isApproved));
      }
    })
    this.userdashService.checkPending(this.dash.username).subscribe(response=>{
      this.isPending = response.pending;
      this.isOverdue = (response.daysToNextInstallment<1)
      this.daysLeft = response.daysToNextInstallment;
    })
  }

  logoutFunction(){
    sessionStorage.clear();
    console.log(sessionStorage.getItem("uname"));
    console.log(sessionStorage.getItem("pid"));
    this.router.navigate(['index']);
  }
  
}
export class DashBoard{
  username:string;
}

export class Card{
  cardNumber:number;
  cardType:String;
  amountGranted:number;
  amountRemaining:number;
  startDate:String;
  expiry_date:String;
}
