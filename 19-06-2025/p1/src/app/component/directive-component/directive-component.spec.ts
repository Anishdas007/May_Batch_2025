import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectiveComponent } from './directive-component';

describe('DirectiveComponent', () => {
  let component: DirectiveComponent;
  let fixture: ComponentFixture<DirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DirectiveComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
});
