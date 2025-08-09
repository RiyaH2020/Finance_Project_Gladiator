import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-search-products',
  templateUrl: './search-products.component.html',
  styleUrls: ['./search-products.component.css']
})
export class SearchProductsComponent implements OnInit {
qualify:Qualify=new Qualify;
products:Array<Product>;
  constructor(private searchService:UserService,private router: Router) { }

  ngOnInit() {
    console.log(sessionStorage.getItem("qualifier"));
    this.qualify.qualifier=sessionStorage.getItem("qualifier");
    this.searchService.searchProducts(this.qualify).subscribe(response=>{
      this.products=response;
      //alert(JSON.stringify(this.products));
      console.log(sessionStorage.getItem('uname'));
    })
  
  }

  getSearchedProduct(event){
    console.log(event.target.name);
    if(sessionStorage.getItem('uname')==null){
      this.router.navigate(['index/login'])
    }
    else{
      sessionStorage.setItem('pid', event.target.name);
      this.router.navigate(['product-info']);
    }
    
  }
  getSearchedProduct1(event,productId){
    console.log(event.target.name);
    if(sessionStorage.getItem('uname')==null){
      this.router.navigate(['index/login'])
    }
    else{
      sessionStorage.setItem('pid',productId);
      this.router.navigate(['product-info']);
    }
    
  }
  }


export class Qualify{
  qualifier:String;
}

export class Product{
  productId:number;
  name:String;
  type:String;
  price:number;
  stockAvailable:number;
  productDetails:String;
  imageUrl:String;


}