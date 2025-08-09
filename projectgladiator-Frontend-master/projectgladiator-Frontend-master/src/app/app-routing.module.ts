import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Product_history, PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component'
import { IndexComponent } from './index/index.component';
import { ProductsListComponent } from './products-list/products-list.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { DocumentUploadComponent } from './document-upload/document-upload.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { Installment, InstallmentComponent } from './installment/installment.component';
import { ProductInfoComponent } from './product-info/product-info.component';
import { PaymentComponent } from './payment/payment.component';
import { DebitCardComponent } from './debit-card/debit-card.component';
import { NetBankingComponent } from './net-banking/net-banking.component';
import { UPIComponent } from './upi/upi.component';
import { BuyConfirmationComponent } from './buy-confirmation/buy-confirmation.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { SearchProductsComponent } from './search-products/search-products.component';
import { ProfileComponent } from './profile/profile.component';
import { PurchasedOrderSummaryComponent } from './purchased-order-summary/purchased-order-summary.component';

import { AdminStartScreenComponent } from './admin-start-screen/admin-start-screen.component';


import { OrderDetailsComponent } from './order-details/order-details.component';
import { RenewComponent } from './renew/renew.component';
import { ViewProductInstallmentComponent } from './view-product-installment/view-product-installment.component';
import { AdminDashboardConfirmationComponent } from './admin-dashboard-confirmation/admin-dashboard-confirmation.component';





const routes: Routes = [
  { path:'',redirectTo:'index', pathMatch: 'full' },
  { path: 'index', component: IndexComponent},
  { path: 'index/login', component: UserloginComponent },
  { path: 'index/register', component: UserRegistrationComponent},
  { path: 'dashboard', component: UserDashboardComponent },
  { path: 'dashboard/products-list', component: ProductsListComponent},
  { path:'dashboard/product', component:PurchaseHistoryComponent},
  { path:'dashboard/transaction', component:TransactionHistoryComponent},
  { path: 'dashboard/logout', redirectTo:'index/login', pathMatch: 'full'},
  { path:'admin',component:AdminDashboardComponent},
  { path:'upload',component:DocumentUploadComponent},
  { path:'admindashboard', component:AdminDashboardComponent},
  { path:'index/adminlogin',component:AdminloginComponent},
  { path:'dashboard/installment',component:InstallmentComponent},
  { path: 'product-info', component:ProductInfoComponent},
  { path:'payment',component:PaymentComponent},
   {path:'installment',component:InstallmentComponent},
   { path:'dashboard/payment',component:PaymentComponent},
  { path:'installment',component:InstallmentComponent},
  { path:'dashboard/profile',component:ProfileComponent},
  { path: 'dashboard/index', redirectTo:'index', pathMatch:'full'},
  {path:'dashboard/purchased-order-summary',component:PurchasedOrderSummaryComponent},
  {path:'dashboard/renew',component:RenewComponent},
  {path:'viewInstallment',component:ViewProductInstallmentComponent},
  {path:'index/products',redirectTo:'dashboard/products-list'},
  {path:'admin-start-screen/index', redirectTo:'index'},
  {path:'adminConfirmation',component:AdminDashboardConfirmationComponent},
  
  { path: 'dashboard/products-list/dashboard',redirectTo:'dashboard', pathMatch: 'full' },
  { path: 'dashboard/product/dashboard',redirectTo:'dashboard', pathMatch: 'full' },
  { path:'dashboard/transaction/dashboard',redirectTo:'dashboard',pathMatch: 'full'},
  { path:'dashboard/installment/dashboard', redirectTo:'dashboard',pathMatch:'full'},
  { path:'dashboard/profile/dashboard', redirectTo:'dashboard',pathMatch:'full'},
  { path:'product-info/dashboard', redirectTo:'dashboard',pathMatch:'full'},
  { path:'viewInstallment/dashboard', redirectTo:'dashboard',pathMatch:'full'},

  { path: 'dashboard/products-list/product',redirectTo:'dashboard/product', pathMatch: 'full' },
  { path: 'dashboard/products-list/transaction',redirectTo:'dashboard/transaction', pathMatch: 'full' },
  { path: 'dashboard/products-list/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },
  { path: 'dashboard/products-list/profile', redirectTo:'dashboard/profile', pathMatch: 'full'},

  { path: 'viewInstallment/product',redirectTo:'dashboard/product', pathMatch: 'full' },
  { path: 'viewInstallment/transaction',redirectTo:'dashboard/transaction', pathMatch: 'full' },
  { path: 'viewInstallment/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },
  { path: 'viewInstallment/profile', redirectTo:'dashboard/profile', pathMatch: 'full'},
  { path: 'viewInstallment/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  
  { path: 'dashboard/product/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  { path: 'dashboard/product/transaction',redirectTo:'dashboard/transaction', pathMatch: 'full' },
  { path: 'dashboard/product/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },
  { path: 'dashboard/product/profile',redirectTo:'dashboard/profile', pathMatch: 'full' },

  { path: 'dashboard/transaction/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  { path: 'dashboard/transaction/product',redirectTo:'dashboard/product', pathMatch: 'full' },
  { path: 'dashboard/transaction/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },
  { path: 'dashboard/transaction/profile',redirectTo:'dashboard/profile', pathMatch: 'full' },

  { path: 'dashboard/installment/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  { path: 'dashboard/installment/product',redirectTo:'dashboard/product', pathMatch: 'full' },
  { path: 'dashboard/installment/transaction',redirectTo:'dashboard/transaction', pathMatch: 'full' },
  { path: 'dashboard/installment/profile',redirectTo:'dashboard/profile', pathMatch: 'full' },

  { path: 'product-info/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  { path:'product-info/product', redirectTo:'dashboard/product',pathMatch:'full'},
  { path:'product-info/transaction', redirectTo:'dashboard/transaction',pathMatch:'full'},
  { path: 'product-info/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },

  {path:'dashboard/product', component:PurchaseHistoryComponent},
  {path:'dashboard/transaction', component:TransactionHistoryComponent},
  { path: 'dashboard/logout', redirectTo:'login', pathMatch: 'full'},
  {path:'admin',component:AdminDashboardComponent},
  {path:'upload',component:DocumentUploadComponent},
  {path:'admindashboard', component:AdminDashboardComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'dashboard/installment',component:InstallmentComponent},
  {path: 'product-info', component:ProductInfoComponent},
  {path:'payment',component:PaymentComponent},
  {path:'installment',component:InstallmentComponent},
  {path:'debitcard',component:DebitCardComponent},
  {path:'netbanking',component:NetBankingComponent},
  {path:'upi',component:UPIComponent},
  {path:'buy-confirmation',component:BuyConfirmationComponent},
  {path:'order-summary',component:OrderSummaryComponent},
  {path:'search',component:SearchProductsComponent},
  {path:'admin-start-screen',component:AdminStartScreenComponent},
  {path:'admin-start-screen/admindashboard', component:AdminDashboardComponent},
  { path: 'order-details', component:OrderDetailsComponent },

  { path: 'buy-confirmation/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  { path:'buy-confirmation/product', redirectTo:'dashboard/product',pathMatch:'full'},
  { path:'buy-confirmation/transaction', redirectTo:'dashboard/transaction',pathMatch:'full'},
  { path: 'buy-confirmation/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },
  { path: 'buy-confirmation/dashboard',redirectTo:'dashboard', pathMatch: 'full' },
  
  { path: 'order-details/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full' },
  { path: 'order-details/product', redirectTo:'dashboard/product',pathMatch:'full'},
  { path: 'order-details/transaction', redirectTo:'dashboard/transaction',pathMatch:'full'},
  { path: 'order-details/installment',redirectTo:'dashboard/installment', pathMatch: 'full' },
  { path: 'order-details/dashboard',redirectTo:'dashboard', pathMatch: 'full' },

  { path: 'admindashboard/index',redirectTo:'index', pathMatch: 'full' },
  { path: 'admin-start-screen/admindashboard/index', redirectTo:'index', pathMatch: 'full'},

  { path: 'index/login/index',redirectTo:'index', pathMatch: 'full' },
  { path:'dashboard/profile/products-list',redirectTo:'dashboard/products-list', pathMatch: 'full'},
  { path:'dashboard/profile/product',redirectTo:'dashboard/product', pathMatch: 'full'},
  { path:'dashboard/profile/transaction',redirectTo:'dashboard/transaction', pathMatch: 'full'},
  { path:'dashboard/profile/installment',redirectTo:'dashboard/installment', pathMatch: 'full'},


  { path:'order-summary/dashboard',redirectTo:'dashboard', pathMatch: 'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
