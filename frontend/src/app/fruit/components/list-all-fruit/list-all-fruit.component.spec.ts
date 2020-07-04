import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllFruitComponent } from './list-all-fruit.component';

describe('ListAllFruitComponent', () => {
  let component: ListAllFruitComponent;
  let fixture: ComponentFixture<ListAllFruitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAllFruitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllFruitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
