import { Component, EventEmitter, input, Output } from '@angular/core';
import { ParentComponent } from '../parent-component/parent-component';
import { Input } from '@angular/core';
import { ServiceTs } from '../../services/service.ts';

@Component({
  selector: 'app-child-component',
  standalone: true,
  imports: [],
  templateUrl: './child-component.html',
  styleUrl: './child-component.scss'
})
export class ChildComponent {
  childTitle: string = 'Child Component';
  @Input() messageFromParent: string = '';
  @Output() messageToParent = new EventEmitter<string>();
  notifyParent() {
    this.messageToParent.emit('Hello from Child Component');
  }

  tasks: any[] = [];
  constructor(public takeService: ServiceTs){}
  ngOnInit() {
    this.takeService.taks$.subscribe((tasks: any[]) => {
      this.tasks = tasks;
    });
  }
}
