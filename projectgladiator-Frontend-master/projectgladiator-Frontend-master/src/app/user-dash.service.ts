import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product_history } from './purchase-history/purchase-history.component';
import { RecentTransaction } from './transaction-history/transaction-history.component';
import { DashBoard } from './user-dashboard/user-dashboard.component';

@Injectable({
  providedIn: 'root'
})
export class UserDashService {

  constructor(private http:HttpClient) { }

  cardDash(dashboard:DashBoard):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/dashboard";
    return this.http.post(url,dashboard);
  }

  productDash(product_username:Product_history):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/product";
    return this.http.post(url,product_username);
  }

  transactionDash(transaction_username:RecentTransaction):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/recentTransactions";
    return this.http.post(url,transaction_username);
  }

  checkPending(username:string):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/isDuePending?username="+username;
    return this.http.get(url);
  }
}
