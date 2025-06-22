 
import { createReducer, on } from '@ngrx/store';
import { addToCart, removeFromCart, increaseQty, decreaseQty, checkout } from '../actions/cart.actions';

export interface CartItem {
  bookId: string;
  quantity: number;
}

const initialState: CartItem[] = [];

export const cartReducer = createReducer(
  initialState,
  on(addToCart, (state, { bookId }) => {
    const existing = state.find(i => i.bookId === bookId);
    if (existing && existing.quantity < 2) {
      return state.map(i => i.bookId === bookId ? { ...i, quantity: i.quantity + 1 } : i);
    } else if (!existing) {
      return [...state, { bookId, quantity: 1 }];
    }
    return state;
  }),
  on(removeFromCart, (state, { bookId }) => state.filter(i => i.bookId !== bookId)),
  on(increaseQty, (state, { bookId }) => state.map(i =>
    i.bookId === bookId && i.quantity < 2 ? { ...i, quantity: i.quantity + 1 } : i
  )),
  on(decreaseQty, (state, { bookId }) =>
    state.map(i => i.bookId === bookId ? { ...i, quantity: i.quantity - 1 } : i)
         .filter(i => i.quantity > 0)
  ),
  on(checkout, () => [])
);
