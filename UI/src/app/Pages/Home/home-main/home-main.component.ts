import {Component, OnInit} from '@angular/core';
import {HomeService} from "../service/home.service";
import {response} from "express";
import {LoginServiceService} from "../../login/service/login-service.service";
import {async} from "rxjs";
import {VenueModel} from "../model/home-models";
import {VenueCardComponent} from "../components/venue-card/venue-card.component";

@Component({
  selector: 'app-home-main',
  standalone: true,
  imports: [VenueCardComponent],
  templateUrl: './home-main.component.html',
  styleUrl: './home-main.component.css'
})
export class HomeMainComponent implements OnInit{
  venues:VenueModel[] = [];
  constructor(private home: HomeService, private login:LoginServiceService)  {
  }
  ngOnInit(): void {
    this.home.getAllVenues().subscribe(
      response =>
        this.venues = response
    )
    }
}
