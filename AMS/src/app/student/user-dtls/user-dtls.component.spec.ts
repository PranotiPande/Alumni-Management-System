import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDtlsComponent } from './user-dtls.component';

describe('UserDtlsComponent', () => {
  let component: UserDtlsComponent;
  let fixture: ComponentFixture<UserDtlsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserDtlsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDtlsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
