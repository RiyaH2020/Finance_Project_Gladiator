import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchasedOrderSummaryComponent } from './purchased-order-summary.component';

describe('PurchasedOrderSummaryComponent', () => {
  let component: PurchasedOrderSummaryComponent;
  let fixture: ComponentFixture<PurchasedOrderSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchasedOrderSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchasedOrderSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
