import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllCertifiacesComponent } from './list-all-certifiaces.component';

describe('ListAllCertifiacesComponent', () => {
  let component: ListAllCertifiacesComponent;
  let fixture: ComponentFixture<ListAllCertifiacesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAllCertifiacesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllCertifiacesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
