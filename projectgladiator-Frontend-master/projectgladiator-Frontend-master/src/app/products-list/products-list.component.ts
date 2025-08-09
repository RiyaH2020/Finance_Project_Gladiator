import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../1. finance/finance.Classes';
import { ProductsListService } from '../products-list.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products: Product[]; 
  isApproved:boolean;
  isLogged:boolean;
  constructor(private productsListService: ProductsListService, private router: Router) { }

  ngOnInit() {
    this.isApproved=((sessionStorage.getItem("approved"))=="true");
    this.isLogged = (sessionStorage.getItem("uname")!==null);
    this.productsListService.getProducts().subscribe(response=>{
      this.products=response;
      console.log(this.products);
    })
  }
  getProduct(event){
    console.log(event.target.name);
    sessionStorage.setItem('pid', event.target.name);
    this.router.navigate(['product-info']);
  }
}
