import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-child',
  imports: [],
  templateUrl: './child.html',
  styleUrl: './child.scss',
  encapsulation: ViewEncapsulation.ShadowDom
})
export class Child {

}
