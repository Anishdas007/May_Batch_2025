 
import { createReducer, on } from '@ngrx/store';
import { loadProducts } from '../actions/products.actions';

export interface Book {
  id: string;
  name: string;
  price: number;
  qtyInStock: number;
  imageUrl: string;
}

export const initialState: ReadonlyArray<Book> = [...Array(20)].map((_, i) => ({
  id: `${i+1}`,
  name: `Book Title ${i+1}`,
  price: parseFloat((Math.random()*20 + 5).toFixed(2)),
  qtyInStock: Math.floor(Math.random()*5),
  imageUrl: `https://via.placeholder.com/150?text=Book+${i+1}`
}));

export const productsReducer = createReducer(
  initialState,
  on(loadProducts, state => state)
);
