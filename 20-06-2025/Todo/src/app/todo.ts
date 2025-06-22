import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

export interface Todo {
  text: string;
  completed: boolean;
}

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  private todos: Todo[] = [];

  private tasksSubject = new BehaviorSubject<Todo[]>(this.todos);
  public tasks$: Observable<Todo[]> = this.tasksSubject.asObservable();

  getTodos(): Todo[] {
    return [...this.todos];
  }

  addTodo(todoText: string): void {
    this.todos.push({ text: todoText, completed: false });
    this.tasksSubject.next([...this.todos]);
  }

  removeTodo(index: number): void {
    this.todos.splice(index, 1);
    this.tasksSubject.next([...this.todos]);
  }

  toggleTodo(index: number): void {
    const todo = this.todos[index];
    if (todo) {
      todo.completed = !todo.completed;
      this.tasksSubject.next([...this.todos]);
    }
  }
}
