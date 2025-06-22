import { CommonModule } from "@angular/common";
import { Component, EventEmitter, Input, Output } from "@angular/core";
import { Book } from "../../store/reducers/products.reducer";

 
@Component({
  selector: 'book-card',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div [class.out-of-stock]="book.qtyInStock===0" [class.blur]="book.qtyInStock===0">
      <img [src]="book.imageUrl" alt="{{book.name}}">
      <h3>{{book.name}}</h3>
      <p>₹{{book.price}}</p>
      <button (click)="add()" [disabled]="book.qtyInStock===0 || cartQty===2">
        Add to Cart {{cartQty>0?'('+cartQty+')':''}}
      </button>
      <div *ngIf="book.qtyInStock === 0">Out of Stock</div>
    </div>
  `,
  styles: [`
    .out-of-stock { filter: grayscale(100%); }
    .blur { opacity: 0.5; }
  `]
})
export class BookCardComponent {
  @Input() book!: Book;
  @Input() cartQty = 0;
  @Output() add = new EventEmitter<void>();
}
