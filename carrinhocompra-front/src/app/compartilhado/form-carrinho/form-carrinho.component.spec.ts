import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCarrinhoComponent } from './form-carrinho.component';

describe('FormCarrinhoComponent', () => {
  let component: FormCarrinhoComponent;
  let fixture: ComponentFixture<FormCarrinhoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormCarrinhoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormCarrinhoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
