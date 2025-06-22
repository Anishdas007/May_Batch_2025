import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ParentComponent} from './Components/parent-component/parent-component';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  imports: [RouterOutlet, ParentComponent],
  standalone: false,
  styleUrl: './app.scss'
})
export class App {
  protected title = 'my-first-project-standalone';
}
