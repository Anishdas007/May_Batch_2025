 
import { createSelector } from '@ngrx/store';
import { AppState } from '../reducers';

export const selectProducts = (s: AppState) => s.products;
