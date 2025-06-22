 
@Component({ selector: 'cart-page', standalone: true, imports: [CommonModule, RouterModule], template: `
  <h1>Your Cart</h1>
  <div *ngFor="let item of cartDetails$ | async">
    <h3>{{item.name}}</h3>
    <p>₹{{item.price}} × {{item.quantity}} = ₹{{item.netAmount}}</p>
    <button (click)="decrease(item.id)">–</button>
    <button (click)="increase(item.id)" [disabled]="item.quantity===2">+</button>
    <button (click)="remove(item.id)">Remove</button>
  </div>
  <h2>Total: ₹{{cartTotal$ | async}}</h2>
  <button (click)="checkout()" [disabled]="(cartTotal$|async)===0">Checkout</button>
` })
export class CartPageComponent {
  cartDetails$ = this.store.select(selectCartDetails);
  cartTotal$ = this.store.select(selectCartTotal);
  constructor(private store: Store){}

  increase(id: string) { this.store.dispatch(increaseQty({ bookId: id })); }
  decrease(id: string) { this.store.dispatch(decreaseQty({ bookId: id })); }
  remove(id: string) { this.store.dispatch(removeFromCart({ bookId: id })); }
  checkout() {
    this.store.dispatch(checkout());
    alert('Purchase successful!');
  }
}
    