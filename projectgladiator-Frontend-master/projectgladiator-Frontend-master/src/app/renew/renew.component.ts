import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-renew',
  templateUrl: './renew.component.html',
  styleUrls: ['./renew.component.css']
})
export class RenewComponent implements OnInit {
renewApp:Renew=new Renew();
  constructor(private userService:UserService,private router:Router) { }
renewCheck(){
  this.renewApp.username=sessionStorage.getItem("uname");
  console.log(this.renewApp.username);
  this.userService.updateCard(this.renewApp).subscribe(response=>{
    alert(JSON.stringify(response));
  })
  this.router.navigate(['dashboard']);
}
  ngOnInit() {
  }

}

export class Renew{
  username:String;
  cardType:String;
}
