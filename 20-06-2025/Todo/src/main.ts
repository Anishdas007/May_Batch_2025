import { bootstrapApplication } from '@angular/platform-browser';
import { TodoComponent } from './app/todo/todo';

bootstrapApplication(TodoComponent)
  .catch(err => console.error(err));
