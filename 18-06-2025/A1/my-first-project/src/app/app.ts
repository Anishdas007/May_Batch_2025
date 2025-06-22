import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ParentComponent } from './component/parent-component/parent-component';

@Component({
  selector: 'app-root',
  imports: [  ParentComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'my-first-project';
}
