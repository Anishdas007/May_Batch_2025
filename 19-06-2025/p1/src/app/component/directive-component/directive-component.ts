import { NgClass, NgStyle } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-directive-component',
  imports: [NgClass,NgStyle],
  templateUrl: './directive-component.html',
  styleUrl: './directive-component.scss'
})
export class DirectiveComponent {
isVisible = true;
  textColor = 'blue';
  fontSize = '16px'; // Fixed: missing '=' and typo in property name
  isActive = true;
  items = ['Item 1', 'Item 2', 'Item 3', 'Item 4'];
 
  toggleVisibility() {
    this.isVisible = !this.isVisible; // Fixed: `I` instead of `!`
  }
 
  changeStyle() {
    this.textColor = this.textColor === 'blue' ? 'red' : 'blue';
    this.fontSize = this.fontSize === '16px' ? '20px' : '16px'; // Fixed typo: fontSize not fontsize
  }
  toggleClass(){
    this.isActive = !this.isActive;
  }
}
