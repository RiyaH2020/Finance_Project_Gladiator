import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order, Product } from '../1. finance/finance.Classes';
import { UserService } from '../user.service';

@Component({
  selector: 'app-installment',
  templateUrl: './installment.component.html',
  styleUrls: ['./installment.component.css']
})
export class InstallmentComponent implements OnInit {

  installments: Array<Installment>;
  // product : Product;
  uname: Username = new Username();
  disablebutton: boolean;
  orders: Order;
  allOrders: Order;
  all: boolean;
  // allInstallments : Array<Installment>;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.uname.username = sessionStorage.getItem('uname');

    this.all = true;
    this.disablebutton = true;
    this.userService.getOrders(this.uname.username).subscribe(response => {
      this.orders = response;
      JSON.stringify(response);
    })



  }

  checkPendingPayment(event) {
    this.userService.pendingInstallments(event.target.id).subscribe(response => {
      if (response.status == "SUCCESS") {
        this.payInstallment(event);
      }
      else {
        alert(response.message);
      }
    })
  }

  isInstallmentPaid(event)
  {
    this.userService.isPaid(event.target.id).subscribe(response => {
      console.log(event.target.id);
      if (response.status == "SUCCESS") {
        this.payInstallment(event);
      }
      else {
        alert(response.message);
      }
    })
  }
  payInstallment(event) {
    sessionStorage.setItem("installmentId", event.target.id);
    this.router.navigate(['payment']);
  }

  viewInstallments(event) {
    this.disablebutton = !this.disablebutton;
    this.userService.getInstallments(event.target.id).subscribe(response => {
      console.log(response);
      this.installments = response;
    })
  }

  viewAllOrders() {
    this.all = !this.all;
    this.userService.getAllOrders(this.uname.username).subscribe(response2 => {
      this.allOrders = response2;
      console.log(JSON.stringify(response2));
    })
  }
}

export class Installment {
  installmentId: number;
  installmentNumber: number;
  dueDate: String;
  installmentAmount: number;
  paymentMode: String;
  paidOnDate: number;
  order: Order;
  status: String;
}

export class Username {
  username: string;
}