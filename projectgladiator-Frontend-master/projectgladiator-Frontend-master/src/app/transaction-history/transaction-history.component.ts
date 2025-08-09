import { Component, OnInit } from '@angular/core';
import { UserDashService } from '../user-dash.service';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {
 
  transaction:RecentTransaction=new RecentTransaction;
  transactions:Array<Transaction>;
  constructor(private userdashService:UserDashService) { }

  ngOnInit() {
    this.transaction.username=sessionStorage.getItem('uname');
    this.userdashService.transactionDash(this.transaction).subscribe(response=>{
        
        if(response.status=='AVAILABLE'){
          this.transactions=response.list;
          //alert(JSON.stringify(response.list));
        }
        else{
          alert(response.status);
        }  
    })
  }

}
export class RecentTransaction{
  username:String;
}
export class Product{
  productId:number;
  name:String;
  type:String;
  price:number;
  stockAvailable:number;
  productDetails:String;
  imageUrl:String;
  placedDate:Date;
}

export class Order{
  orderId:number;
  placedDate:String;
  receivedDate:String;
  amount: number;
  emiScheme: number;
  status: String;
  product:Product=new Product();
}
export class Transaction{
  installmentId:number;
  installmentNumber:number;
  dueDate:String;
  status:String;
  installmentAmount:number;
  paymentMode:String;
  paidOnDate:String;
  order:Order=new Order();
}




