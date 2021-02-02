import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobOpeningsComponent } from './job-openings.component';

describe('JobOpeningsComponent', () => {
  let component: JobOpeningsComponent;
  let fixture: ComponentFixture<JobOpeningsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobOpeningsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobOpeningsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
