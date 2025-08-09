import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderProduct } from './1. finance/finance.Classes';

@Injectable({
  providedIn: 'root'
})
export class ProductsListService {

  constructor(private http: HttpClient) { }

  getProducts() : Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/products-list";
    return this.http.get(url);
  }

  productInfo(productId:number,cardNum:String) : Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/get-product?productId="+productId+"&cardNum="+cardNum;
    return this.http.get(url);
  }

  placeOrder(orderProduct:OrderProduct):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/order";
    return this.http.post(url,orderProduct);
  }

  featureProduct(): Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/index"
    return this.http.get(url);
  }

  getProductInfo(productId:number):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/product-info?productId="+productId;
    return this.http.get(url);
  }
}
