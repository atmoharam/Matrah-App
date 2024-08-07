import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {APIs} from "../conest/APIs";
import {VenueModel} from "../model/home-models";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  getAllVenues(): Observable<any> {
    return this.http.get(APIs.GET_ALL)
  }
}
