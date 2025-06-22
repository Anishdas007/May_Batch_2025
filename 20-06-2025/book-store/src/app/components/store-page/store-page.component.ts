import { Component } from "@angular/core";
import { selectProducts } from "../../store/selectors/cart.selectors";
import { map } from "rxjs";
import { Store } from "@ngrx/store";

 
@Component({ selector: 'store-page', standalone: true, imports: [CommonModule, BookCardComponent], template: `
  <h1>Book Store</h1>
  <div class="grid">
    <book-card
      *ngFor="let book of products$ | async"
      [book]="book"
      [cartQty]="(cart$ | async)?.find(i=>i.bookId===book.id)?.quantity || 0"
      (add)="addToCart(book.id)"
    ></book-card>
  </div>
  <button routerLink="/cart">Go to Cart ({{(cartTotalQty$|async)}})</button>
` })
export class StorePageComponent {
  products$ = this.store.select(selectProducts);
  cart$ = this.store.select(selectCart);
  cartTotalQty$ = this.cart$.pipe(map(c=>c.reduce((sum,i)=>sum+i.quantity,0)));
  constructor(private store: Store) {}
  addToCart(id: string) { this.store.dispatch(addToCart({ bookId: id })); }
}
