import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddZemljisteComponent } from './add-zemljiste.component';

describe('AddZemljisteComponent', () => {
  let component: AddZemljisteComponent;
  let fixture: ComponentFixture<AddZemljisteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddZemljisteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddZemljisteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
