import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentDetails } from '../1. finance/finance.Classes';
import { UserService } from '../user.service';

@Component({
  selector: 'app-net-banking',
  templateUrl: './net-banking.component.html',
  styleUrls: ['./net-banking.component.css']
})
export class NetBankingComponent implements OnInit {

  pay:PaymentDetails= new PaymentDetails();
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
  }

  Pay(){

    this.pay.installmentid=parseInt(sessionStorage.getItem("installmentId"));
    console.log(this.pay.installmentid);
     this.userService.payInstallment(this.pay).subscribe(response=>{
      console.log(JSON.stringify(response));
      alert(response.message);

      this.router.navigate(['dashboard/installment']);
  })
}
}
