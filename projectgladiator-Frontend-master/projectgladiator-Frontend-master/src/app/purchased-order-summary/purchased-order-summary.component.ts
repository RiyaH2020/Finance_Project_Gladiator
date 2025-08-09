import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-purchased-order-summary',
  templateUrl: './purchased-order-summary.component.html',
  styleUrls: ['./purchased-order-summary.component.css']
})
export class PurchasedOrderSummaryComponent implements OnInit {
pid:number;
  constructor() { }

  ngOnInit() {
    this.pid=parseInt(sessionStorage.getItem("pid"));
  }

}
