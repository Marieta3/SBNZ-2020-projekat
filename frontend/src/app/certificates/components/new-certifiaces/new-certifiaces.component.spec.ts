import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCertifiacesComponent } from './new-certifiaces.component';

describe('NewCertifiacesComponent', () => {
  let component: NewCertifiacesComponent;
  let fixture: ComponentFixture<NewCertifiacesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewCertifiacesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCertifiacesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
