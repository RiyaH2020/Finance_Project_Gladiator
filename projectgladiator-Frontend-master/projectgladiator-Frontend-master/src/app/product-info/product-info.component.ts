import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderProduct, Product } from '../1. finance/finance.Classes';
import { ProductsListService } from '../products-list.service';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})
export class ProductInfoComponent implements OnInit {

  product: Product;
  features: string[];
  monthsOptions = ["Select","3","6","9","12"];
  selectedMonths = "Select";
  emiPerMonth:number=0;
  message:string;
  months:number;
  orderProduct:OrderProduct = new OrderProduct();
  isNotApproved:boolean;
  isLogged:boolean;

  constructor(private productsListService: ProductsListService, private router: Router) { }

  ngOnInit() {
    let productId1 = +sessionStorage.getItem("pid");
    console.log(productId1);
    console.log(sessionStorage.getItem("approved"));
    this.isLogged = (sessionStorage.getItem("uname")!==null);
    this.isNotApproved=((sessionStorage.getItem("approved"))==="false");
    console.log(this.isNotApproved);
    this.productsListService.getProductInfo(productId1).subscribe(response=>{
      this.product=response;
      sessionStorage.setItem("pname",this.product.name);
      sessionStorage.setItem("price",""+this.product.price);
      this.features=(this.product).productDetails.split(",");
      console.log(this.product);
      console.log(this.features);
    })
  }

  calculateEmi(){
    this.emiPerMonth=0;
    if(this.selectedMonths!=="Select"){
      this.months =+ this.selectedMonths;
      this.emiPerMonth = this.product.price/this.months;
      sessionStorage.setItem('emi-scheme', this.months.toString());
      sessionStorage.setItem('emi', this.emiPerMonth.toString());
    }
  }
  validate(){
    if(this.emiPerMonth==0){
      this.message="Select number of months to proceed!";
    }
    else{
      this.message="";
      // this.orderProduct.productId=parseInt(sessionStorage.getItem("pid"));
      // this.orderProduct.username=sessionStorage.getItem("uname");
      // this.orderProduct.scheme=this.months;
      //this.router.navigate(['buy-confirmation']);
      if(this.isLogged)
      {
        this.router.navigate(['order-details']);
      }
      else
      this.router.navigate(['index/login']);
      // this.productsListService.placeOrder(this.orderProduct).subscribe( response=>{
      //   alert(JSON.stringify(response));
      // })
    }
  }
}
