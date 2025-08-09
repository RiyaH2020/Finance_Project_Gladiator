import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  emiPerMonth : String;
  months : number;
  productName:string;
  productPrice:string;
  constructor(private router:Router) { }

  ngOnInit() {
    this.emiPerMonth = sessionStorage.getItem('emi');
    this.months = parseInt(sessionStorage.getItem('emi-scheme'));
    this.productName = sessionStorage.getItem("pname");
    this.productPrice = sessionStorage.getItem("price");
  }
  confirmOrder(){
    this.router.navigate(['buy-confirmation']);
  }
}
