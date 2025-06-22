import { bootstrapApplication } from '@angular/platform-browser';
import { provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { AppComponent } from './app';
import { reducers } from './store/reducers';

bootstrapApplication(AppComponent, {
  providers: [
    provideStore(reducers),
    provideStoreDevtools({ maxAge: 25 }),
  ]
});
