import { HttpInterceptorFn } from '@angular/common/http';
import {LocalStorageService} from "../LocalStorage/local-storage.service";
import {inject} from "@angular/core";

export const authInterceptor: HttpInterceptorFn = (req, next) => {
const token = inject(LocalStorageService).getItem('user-data')?.token;
  const reqWithHeader = req.clone({
    headers: req.headers.set('Authorization', `Bearer ${token}`),
  });
  if(token){  return next(reqWithHeader);}
  return next(req)
};
