import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TodoService } from '../todo';

// Define the Todo interface if not already defined elsewhere
export interface Todo {
  text: string;
  completed: boolean;
}

@Component({
  standalone: true,
  selector: 'app-todo',
  imports: [CommonModule, FormsModule],
  templateUrl: './todo.html',
  styleUrls: ['./todo.scss']
})
export class TodoComponent {
  todos: Todo[] = [];
  newTodo = '';

  constructor(private todoService: TodoService) {
    this.todos = this.todoService.getTodos();
  }

  addTodo() {
    if (this.newTodo.trim()) {
      this.todoService.addTodo(this.newTodo.trim());
      this.todos = this.todoService.getTodos();
      this.newTodo = '';
    } else {
      alert('Please enter a valid todo item.');
    }
  }

  removeTodo(index: number) {
    this.todoService.removeTodo(index);
    this.todos = this.todoService.getTodos();
  }

  toggleTodo(index: number) {
    this.todoService.toggleTodo(index);
    this.todos = this.todoService.getTodos();
  }
}
