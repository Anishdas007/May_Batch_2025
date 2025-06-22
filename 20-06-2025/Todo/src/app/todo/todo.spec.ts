import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TodoComponent } from './todo';
import { FormsModule } from '@angular/forms';
import { TodoService } from '../todo';

interface Todo {
  text: string;
  completed: boolean;
}

describe('TodoComponent with Service', () => {
  let component: TodoComponent;
  let fixture: ComponentFixture<TodoComponent>;
  let mockTodoService: jasmine.SpyObj<TodoService>;

  const mockTodos: Todo[] = [
    { text: 'mocked todo', completed: false }
  ];

  beforeEach(async () => {
    mockTodoService = jasmine.createSpyObj('TodoService', ['getTodos', 'addTodo', 'removeTodo', 'toggleTodo']);

    mockTodoService.getTodos.and.returnValue([...mockTodos]);

    await TestBed.configureTestingModule({
      imports: [TodoComponent, FormsModule],
      providers: [{ provide: TodoService, useValue: mockTodoService }]
    }).compileComponents();

    fixture = TestBed.createComponent(TodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch todos from the service on init', () => {
    expect(mockTodoService.getTodos).toHaveBeenCalled();
    expect(component.todos).toEqual(mockTodos);
  });

  it('should call addTodo on the service', () => {
    component.newTodo = 'New Task';

    const updatedTodos: Todo[] = [
      { text: 'mocked todo', completed: false },
      { text: 'New Task', completed: false }
    ];
    mockTodoService.getTodos.and.returnValue(updatedTodos);

    component.addTodo();

    expect(mockTodoService.addTodo).toHaveBeenCalledWith('New Task');
    expect(component.todos).toEqual(updatedTodos);
  });

  it('should call removeTodo on the service', () => {
    const updatedTodos: Todo[] = [
      { text: 'mocked todo 2', completed: false }
    ];
    mockTodoService.getTodos.and.returnValue(updatedTodos);

    component.removeTodo(0);

    expect(mockTodoService.removeTodo).toHaveBeenCalledWith(0);
    expect(component.todos).toEqual(updatedTodos);
  });

  it('should call toggleTodo on the service', () => {
    const toggledTodos: Todo[] = [
      { text: 'mocked todo', completed: true }
    ];
    mockTodoService.getTodos.and.returnValue(toggledTodos);

    component.toggleTodo(0);

    expect(mockTodoService.toggleTodo).toHaveBeenCalledWith(0);
    expect(component.todos[0].completed).toBeTrue();
  });
});
