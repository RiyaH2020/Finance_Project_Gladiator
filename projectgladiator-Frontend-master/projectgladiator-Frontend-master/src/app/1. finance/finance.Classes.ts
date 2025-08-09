export class Register{
   
    name : string;
    phoneNumber : number;
    email : string;
    username : string;
    password : string;
    address : string;
    cardType : string;
    bankName : string;
    accuntNumber : string;
    ifsc : string;
    document : string;
    status:string;
    admin: Admin = new Admin();
  }

  export class Login{
    name: string;
    password: string;
  }

  export class Admin{
    adminId: number;
  }
  export class Product{
    productId: number;
    name: string;
    type: string;
    price: number;
    stockAvailable: number;
    productDetails: string;
    imageUrl: string;
  }
  
  export class OrderProduct{
    username:string;
    scheme:number;
    productId:number;
  }

export class Order{
  orderId : number;
  placedDate : String;
  receivedDate : String;
  amount : number;
  emiScheme : number;
  status : String;
  product : Product;
}

export class PaymentDetails{
  installmentid:number;
  paymentMode:String;
}