import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceTs {
  private taskSubject = new BehaviorSubject<any[]>([]);
  taks$ = this.taskSubject.asObservable();
  TaskAdd(task: string) {
    console.log('Task added:', task);
    const currentTasks = this.taskSubject.getValue();
    const newTask = {
      task: task,
      completed: false
    };
    currentTasks.push(newTask);
    this.taskSubject.next(currentTasks);
  }
}
