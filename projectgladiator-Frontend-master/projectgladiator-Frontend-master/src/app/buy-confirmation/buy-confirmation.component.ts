import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderProduct } from '../1. finance/finance.Classes';
import { ProductsListService } from '../products-list.service';

@Component({
  selector: 'app-buy-confirmation',
  templateUrl: './buy-confirmation.component.html',
  styleUrls: ['./buy-confirmation.component.css']
})
export class BuyConfirmationComponent implements OnInit {

  constructor(private productsListService: ProductsListService, private router: Router) { }


  orderProduct:OrderProduct = new OrderProduct();
  emiPerMonth : String;
  months : number;
  address : String;
  pin : String;
  phone : String; 
  ngOnInit() {
    this.emiPerMonth = sessionStorage.getItem('emi');
    this.months = parseInt(sessionStorage.getItem('emi-scheme'));
    // alert(this.emiPerMonth);
  }

  payNow()
  { 
    sessionStorage.setItem('address', this.address.toString());
    sessionStorage.setItem('pin', this.pin.toString());
    sessionStorage.setItem('phone', this.phone.toString());
    sessionStorage.setItem('months', this.months.toString());

    this.orderProduct.productId=parseInt(sessionStorage.getItem("pid"));
      this.orderProduct.username=sessionStorage.getItem("uname");
      this.orderProduct.scheme=this.months;
      this.productsListService.placeOrder(this.orderProduct).subscribe( response=>{
        alert(JSON.stringify(response));
        sessionStorage.setItem('orderStatus',response.status);
        this.router.navigate(['order-summary']);
      })
  }

}
