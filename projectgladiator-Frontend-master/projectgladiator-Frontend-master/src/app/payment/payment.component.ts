import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentDetails } from '../1. finance/finance.Classes';
import { UserService } from '../user.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  pay:PaymentDetails=new PaymentDetails();

  

  constructor(private userService:UserService, private router: Router) { }
  Pay(){
    
    // this.pay.installmentid=parseInt(sessionStorage.getItem("installmentId"));
    // console.log(this.pay.installmentid);
    //  this.userService.payInstallment(this.pay).subscribe(response=>{
    //   console.log(JSON.stringify(response));
      //alert(response.message);
      //window.location.reload();
     
     // this.router.navigate(['installment']);
      
     if(this.pay.paymentMode=="Net Banking"){
        
        this.router.navigate(['netbanking']);
      }
      else if(this.pay.paymentMode=="Debit Card"){

        this.router.navigate(['debitcard']);
      }
      else if(this.pay.paymentMode=="UPI"){

        this.router.navigate(["upi"]);
      }
    //})

  }
  ngOnInit() {
  }

}


