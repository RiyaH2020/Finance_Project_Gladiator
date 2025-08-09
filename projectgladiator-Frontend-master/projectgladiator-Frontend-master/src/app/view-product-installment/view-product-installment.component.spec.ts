import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProductInstallmentComponent } from './view-product-installment.component';

describe('ViewProductInstallmentComponent', () => {
  let component: ViewProductInstallmentComponent;
  let fixture: ComponentFixture<ViewProductInstallmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewProductInstallmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProductInstallmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
