import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDashboardConfirmationComponent } from './admin-dashboard-confirmation.component';

describe('AdminDashboardConfirmationComponent', () => {
  let component: AdminDashboardConfirmationComponent;
  let fixture: ComponentFixture<AdminDashboardConfirmationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDashboardConfirmationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDashboardConfirmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
