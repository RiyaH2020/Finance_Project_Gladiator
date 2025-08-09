import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDashService } from '../user-dash.service';

@Component({
  selector: 'app-purchase-history',
  templateUrl: './purchase-history.component.html',
  styleUrls: ['./purchase-history.component.css']
})
export class PurchaseHistoryComponent implements OnInit {
prod_hist:Product_history=new Product_history;
orders:Array<Order>;
  constructor(private userdashService:UserDashService,private router:Router) { }

  ngOnInit() {
    this.prod_hist.username=sessionStorage.getItem('uname');
    this.userdashService.productDash(this.prod_hist).subscribe(response=>{
      if(response.status=='PURCHASED'){
        this.orders=response.orders;
        //alert(JSON.stringify(this.orders));
      }
      else{
        alert(response.status);
      }
      
    })
  }

  function (event,orderId,emiScheme,placedDate) {
    sessionStorage.setItem("orderid",orderId);
    sessionStorage.setItem("scheme",emiScheme);
    sessionStorage.setItem("date",placedDate)
    this.router.navigate(['viewInstallment']);
    
  }
  function1 (event,productId) {
    sessionStorage.setItem("pid",productId);
    this.router.navigate(['product-info']);
    
  }
  
 /* function1 (event,prodcutId,address,emiScheme) {
    sessionStorage.setItem("pid",prodcutId);
     sessionStorage.setItem("orderStatus","SUCCESS");
     sessionStorage.setItem("address",address);
    sessionStorage.setItem("pin","1212");
    sessionStorage.setItem("phone","1212");
    sessionStorage.setItem("emi",emiScheme);
    this.router.navigate(['dashboard/purchased-order-summary']);
    
  }
*/

}
export class Product_history{
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
