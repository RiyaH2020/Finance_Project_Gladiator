import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username:string;
  currentPage:string;
  constructor(private router:Router) { }

  ngOnInit() {
    this.username=sessionStorage.getItem("uname");
    if(this.router.url==="/dashboard")
    this.currentPage="Dashboard";
    if(this.router.url==="/dashboard/products-list")
    this.currentPage="Product List";
    if(this.router.url==="/product-info")
    this.currentPage="Product Info";
    if(this.router.url==="/dashboard/product")
    this.currentPage="Purchase History";
    if(this.router.url==="/dashboard/transaction")
    this.currentPage="Transactions";
    if(this.router.url==="/dashboard/installment")
    this.currentPage="Installment";
    if(this.router.url==="/order-details")
    this.currentPage="Order Details";
    if(this.router.url==="/buy-confirmation")
    this.currentPage="Order Confirmation";
  }

}
