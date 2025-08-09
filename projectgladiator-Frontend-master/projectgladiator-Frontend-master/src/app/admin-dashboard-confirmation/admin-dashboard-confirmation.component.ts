import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-dashboard-confirmation',
  templateUrl: './admin-dashboard-confirmation.component.html',
  styleUrls: ['./admin-dashboard-confirmation.component.css']
})
export class AdminDashboardConfirmationComponent implements OnInit {
isTcAccepted:boolean;
id:number;
name:String;
card:String;
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
    this.id =parseInt(sessionStorage.getItem("userId"));
    this.name=sessionStorage.getItem("username");
    this.card=sessionStorage.getItem("cardType");
  }
  approve(){
    if(confirm("Are you sure you want to approve?"))
    {
    // console.log(event.target.id);
   

    
    this.userService.getCardType(this.id).subscribe(response=>
      {
        // console.log(JSON.stringify(response));
        this.card = response.cardType;
        // console.log(this.cardType);
        this.userService.changeStatus(this.id,this.card).subscribe(response2=>
      {
        if(response2.status=="FAILED")
        {
          alert(response2.message);
        }
        else
        {
          window.location.reload();
        }
        console.log(JSON.stringify(response2));
      })
        
      })
    }
    this.router.navigate(['admindashboard']);
  }

}
