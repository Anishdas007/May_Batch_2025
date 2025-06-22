import { bootstrapApplication } from '@angular/platform-browser';
import { provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import App from './app';
import { reducers } from './store/reducers';

bootstrapApplication(App, {
  providers: [
    provideStore(reducers),
    provideStoreDevtools({ maxAge: 25 }),
  ]
});

