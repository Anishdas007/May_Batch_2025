import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule.forRoot([
    { path: '', component: StorePageComponent },
    { path: 'cart', component: CartPageComponent }
  ])],
  template: `
    <router-outlet></router-outlet>
  `
})
export class AppComponent {}

