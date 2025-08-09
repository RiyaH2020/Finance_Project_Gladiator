import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsListService } from '../products-list.service';

@Component({
  selector: 'app-search-component',
  templateUrl: './search-component.component.html',
  styleUrls: ['./search-component.component.css']
})
export class SearchComponentComponent implements OnInit {
  qualifier:string;
  constructor(private productsListService: ProductsListService, private router: Router) { }

  ngOnInit() {
  }
  search(){
    console.log(this.qualifier);
    sessionStorage.setItem("qualifier",this.qualifier);
    this.router.navigate(['search']);
  }

 
}
