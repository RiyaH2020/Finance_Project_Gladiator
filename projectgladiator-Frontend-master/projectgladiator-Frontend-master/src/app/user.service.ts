import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Login, PaymentDetails, Register } from './1. finance/finance.Classes';
import { RegisterDoc } from './document-upload/document-upload.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { Qualify } from './search-products/search-products.component';
import { UpdateUser } from './profile/profile.component';
import { Renew } from './renew/renew.component';




@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(login:Login) : Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/login";
    return this.http.post(url,login);
  }

  getAllUsers(adminId : number) : Observable<any>{
    let url= "http://localhost:8080/projectgladiator-finance/finance/getAllUser?adminId="+adminId;
    return this.http.get(url);
  }

  changeStatus(userId:number,cardType:String) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/changestatus?userId="+userId+"&status=Approved&cardType="+cardType;
    return this.http.get(url);
  }
  register(register:Register) : Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/register";
    return this.http.post(url,register);
  }

  documentUpload(formdata:FormData):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/upload";
    return this.http.post(url,formdata);

  }
  adminLogin(login:Login) : Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/adminlogin";
    return this.http.post(url,login);
  }

  getCardType(userId:number) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/getcardtype?userId="+userId;
    return this.http.get(url);
  }



  payInstallment(payment:PaymentDetails) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/payinstallment";
    return this.http.post(url,payment);
  }

  pendingInstallments(installmentId:number) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/pending?installmentId="+installmentId;
    return this.http.get(url);
  }

  searchProducts(qualify:Qualify):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/search";
    return this.http.post(url,qualify);
  }

  getOrders(username:String) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/getorders?username="+username;
    return this.http.get(url);
  }

  getInstallments(orderid : number) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/getinstallment?orderId="+orderid;
    return this.http.get(url);
  }
  

  getProfile(uname:string):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/get-profile?uname="+uname;
    return this.http.get(url);
  }

  updateProfile(updateUser:UpdateUser):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/update-profile";
    return this.http.post(url,updateUser);
  }

  getAllOrders(username:String) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/getallorders?username="+username;
    return this.http.get(url);
  }

  isPaid(orderId:number) : Observable<any>{
    let url = "http://localhost:8080/projectgladiator-finance/finance/ispaid?orderId="+orderId;
    return this.http.get(url);
  }

  getPendingCount(adminId:number):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/fetchpendingcount?adminId="+adminId;
    return this.http.get(url);
  }

  updateCard(renewApp:Renew):Observable<any>{
    let url="http://localhost:8080/projectgladiator-finance/finance/update";
    return this.http.post(url,renewApp);
  }

  fetchinstallmentbyOrder(orderId:number):Observable<any>{
   let url=" http://localhost:8080/projectgladiator-finance/finance/getinstallment?orderId="+orderId;
   return this.http.get(url);
  }
  

}
