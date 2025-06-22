import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TodoComponent } from './todo/todo';

@Component({
  selector: 'app-root',
  imports: [ TodoComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
   title = 'Hello, Todo';
}
