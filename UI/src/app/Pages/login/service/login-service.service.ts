import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {APIs} from "../conest/APIs";
import {LoginRequest, LoginResponse} from "../model/login-models";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient) { }

  login(request : LoginRequest):Observable<LoginResponse>{
    return this.http.post<LoginResponse>(APIs.LOGIN, request);
  }
}
