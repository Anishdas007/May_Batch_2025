import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToDoManager } from './to-do-manager';

describe('ToDoManager', () => {
  let component: ToDoManager;
  let fixture: ComponentFixture<ToDoManager>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ToDoManager]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ToDoManager);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
