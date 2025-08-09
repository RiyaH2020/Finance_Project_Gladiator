import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsListService } from '../products-list.service';
import { Product } from '../purchase-history/purchase-history.component';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  features: string[];
  product:Product = new Product();
  
  constructor(private productsListService: ProductsListService, private router: Router) { }

  ngOnInit() {
    this.productsListService.featureProduct().subscribe(response=>{
      this.product=response;
      this.features=response.productDetails.split(",");
    })
  }
  getProduct(event){
    sessionStorage.setItem('pid', event.target.name);
    if(sessionStorage.getItem("uname")!=null&&sessionStorage.getItem("cardnum")!=null)
    this.router.navigate(['product-info']);
    else if(sessionStorage.getItem("uname")!=null)
    this.router.navigate(['dashboard']);
    else
    this.router.navigate(['index/login']);
  }
}
