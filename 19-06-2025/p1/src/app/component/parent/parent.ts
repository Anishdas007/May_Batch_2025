import { Component, ViewEncapsulation } from '@angular/core';
import { Child } from '../child/child';
import { DirectiveComponent } from '../directive-component/directive-component';

@Component({
  selector: 'app-parent',
  imports: [Child,DirectiveComponent],
  templateUrl: './parent.html',
  styleUrl: './parent.scss',
  encapsulation:ViewEncapsulation.ShadowDom
})
export class Parent {

}
