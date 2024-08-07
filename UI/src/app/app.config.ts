import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, provideHttpClient, withInterceptors} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {authInterceptor} from "./common/Interceptor/auth.interceptor";

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes), provideClientHydration(),ReactiveFormsModule,
    provideHttpClient(withInterceptors([authInterceptor])),
  ],
};
