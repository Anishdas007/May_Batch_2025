 
import { productsReducer } from './products.reducer';
import { cartReducer } from './cart.reducer';
import { ActionReducerMap } from '@ngrx/store';

export interface AppState {
  products: ReturnType<typeof productsReducer>;
  cart: ReturnType<typeof cartReducer>;
}

export const reducers: ActionReducerMap<AppState> = {
  products: productsReducer,
  cart: cartReducer,
};
