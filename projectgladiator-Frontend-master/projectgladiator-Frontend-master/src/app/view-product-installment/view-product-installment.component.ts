import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-view-product-installment',
  templateUrl: './view-product-installment.component.html',
  styleUrls: ['./view-product-installment.component.css']
})
export class ViewProductInstallmentComponent implements OnInit {
orderId:number;
scheme:String;
date:String;
installments:Array<Installment>;
  constructor(private userService:UserService) { }
  

  ngOnInit() {
    this.orderId=parseInt(sessionStorage.getItem("orderid"));
    this.scheme=sessionStorage.getItem("scheme");
    this.date=sessionStorage.getItem("date");
    this.userService.fetchinstallmentbyOrder(this.orderId).subscribe(response=>{
      this.installments=response;
     //alert(JSON.stringify(this.installments));
      
    })
  }
  }

export class Installment{
  installmentId:number;
  installmentNumber:number;
  dueDate:String;
  status:String;
  installmentAmount:number;
  paymentMode:String;
  paidOnDate:String;
}