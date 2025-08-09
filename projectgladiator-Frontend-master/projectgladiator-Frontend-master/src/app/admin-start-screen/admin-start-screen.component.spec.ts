import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminStartScreenComponent } from './admin-start-screen.component';

describe('AdminStartScreenComponent', () => {
  let component: AdminStartScreenComponent;
  let fixture: ComponentFixture<AdminStartScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminStartScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminStartScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
