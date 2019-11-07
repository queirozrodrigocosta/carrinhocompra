import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarItemComponent } from './criar-item.component';

describe('CriarItemComponent', () => {
  let component: CriarItemComponent;
  let fixture: ComponentFixture<CriarItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
