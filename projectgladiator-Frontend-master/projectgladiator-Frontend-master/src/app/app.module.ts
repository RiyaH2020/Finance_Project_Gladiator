import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { IndexComponent } from './index/index.component';
import { ProductsListComponent } from './products-list/products-list.component';
import { ProductInfoComponent } from './product-info/product-info.component';
import { DocumentUploadComponent } from './document-upload/document-upload.component';
import { PurchaseProductComponent } from './purchase-product/purchase-product.component';
import { InstallmentComponent } from './installment/installment.component';
import { PaymentComponent } from './payment/payment.component';
import { DebitCardComponent } from './debit-card/debit-card.component';
import { UPIComponent } from './upi/upi.component';
import { NetBankingComponent } from './net-banking/net-banking.component';
import { BuyConfirmationComponent } from './buy-confirmation/buy-confirmation.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { SearchProductsComponent } from './search-products/search-products.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchComponentComponent } from './search-component/search-component.component';
import { ProfileComponent } from './profile/profile.component';
import { HeaderComponent } from './header/header.component';
import { PurchasedOrderSummaryComponent } from './purchased-order-summary/purchased-order-summary.component';

import { AdminStartScreenComponent } from './admin-start-screen/admin-start-screen.component';


import { OrderDetailsComponent } from './order-details/order-details.component';
import { RenewComponent } from './renew/renew.component';
import { ViewProductInstallmentComponent } from './view-product-installment/view-product-installment.component';
import { AdminDashboardConfirmationComponent } from './admin-dashboard-confirmation/admin-dashboard-confirmation.component';




@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    AdminloginComponent,
    UserRegistrationComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    PurchaseHistoryComponent,
    TransactionHistoryComponent,
    IndexComponent,
    ProductsListComponent,
    DocumentUploadComponent, 
    PurchaseProductComponent,
    ProductInfoComponent,
    InstallmentComponent,
    PaymentComponent,
    SearchProductsComponent,
    NavbarComponent,

    DebitCardComponent,
    UPIComponent,
    NetBankingComponent,

    BuyConfirmationComponent,
    OrderSummaryComponent,
    SearchProductsComponent,
    SearchComponentComponent,
    ProfileComponent,
    HeaderComponent,
    PurchasedOrderSummaryComponent,
    AdminStartScreenComponent,
    OrderDetailsComponent,
    RenewComponent,
    ViewProductInstallmentComponent,
    AdminDashboardConfirmationComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
