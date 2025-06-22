import { Component } from '@angular/core';
import { ChildComponent } from '../child-component/child-component';
import { FormsModule } from '@angular/forms';
import { ServiceTs } from '../../services/service.ts';

@Component({
  selector: 'app-parent-component',
  standalone: true,
  imports: [FormsModule, ChildComponent],
  templateUrl: './parent-component.html',
  styleUrl: './parent-component.scss'
})
export class ParentComponent {

  constructor(public AddTask: ServiceTs){}

  total  = 0;
  completed = 0;
  pending=0;

  task: string = '';
  AddToTask() {
    this.task = this.task.trim();
    this.AddTask.TaskAdd(this.task);
  }

}
