import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsListService } from '../products-list.service';
import { Product } from '../purchase-history/purchase-history.component';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {

  address : String;
  pin : String;
  phone : String; 
  emiPerMonth : String;
  months : number;
  product: Product;
  orderStatus : String;
  status : boolean;

  constructor(private productsListService: ProductsListService, private router: Router) { }

  ngOnInit() {
    let productId1 = +sessionStorage.getItem("pid");
    let cardNum = sessionStorage.getItem("cardnum");
    this.orderStatus = sessionStorage.getItem("orderStatus");
    this.address=sessionStorage.getItem("address");
    this.pin=sessionStorage.getItem("pin");
    this.phone=sessionStorage.getItem("phone");
    this.emiPerMonth=sessionStorage.getItem("emi");
    this.months=parseInt(sessionStorage.getItem("months"));
    this.productsListService.productInfo(productId1,cardNum).subscribe(response=>{
      this.product=response.product;
      console.log(this.orderStatus);
      if(this.orderStatus=="SUCCESS")
      {
        this.status=true;
      }
      else
      {
        this.status=false;
      }
    })
  }

}
