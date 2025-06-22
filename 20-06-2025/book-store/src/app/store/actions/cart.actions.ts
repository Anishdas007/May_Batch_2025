 
import { createAction, props } from '@ngrx/store';

export const addToCart = createAction('[Cart] Add', props<{ bookId: string }>());
export const removeFromCart = createAction('[Cart] Remove', props<{ bookId: string }>());
export const increaseQty = createAction('[Cart] Increase', props<{ bookId: string }>());
export const decreaseQty = createAction('[Cart] Decrease', props<{ bookId: string }>());
export const checkout = createAction('[Cart] Checkout');
