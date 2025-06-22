import { TestBed } from '@angular/core/testing';
import { TodoService, Todo } from './todo';
import { take } from 'rxjs';

describe('TodoService', () => {
  let service: TodoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TodoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should initialize with an empty todo list', (done) => {
    service.tasks$.pipe(take(1)).subscribe((tasks) => {
      expect(tasks).toEqual([]);
      done();
    });
  });

  it('should add a new todo', (done) => {
    service.addTodo('Buy milk');

    service.tasks$.pipe(take(1)).subscribe((tasks: Todo[]) => {
      expect(tasks.length).toBe(1);
      expect(tasks[0].text).toBe('Buy milk');
      expect(tasks[0].completed).toBeFalse();
      done();
    });
  });

  it('should toggle the completed state of a todo', (done) => {
    service.addTodo('Buy eggs');

    service.toggleTodo(0);

    service.tasks$.pipe(take(1)).subscribe((tasks: Todo[]) => {
      expect(tasks[0].completed).toBeTrue();
      done();
    });
  });

  it('should remove a todo by index', (done) => {
    service.addTodo('Task A');
    service.addTodo('Task B');

    service.removeTodo(0);

    service.tasks$.pipe(take(1)).subscribe((tasks: Todo[]) => {
      expect(tasks.length).toBe(1);
      expect(tasks[0].text).toBe('Task B');
      done();
    });
  });
});
