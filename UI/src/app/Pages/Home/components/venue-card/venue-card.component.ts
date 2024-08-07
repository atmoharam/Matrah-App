import {Component, Input} from '@angular/core';
import {VenueModel} from "../../model/home-models";
import {ActivatedRoute} from "@angular/router";
import {Router} from "express";
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-venue-card',
  standalone: true,
  imports: [
    NgOptimizedImage
  ],
  templateUrl: './venue-card.component.html',
  styleUrl: './venue-card.component.css'
})
export class VenueCardComponent {
  @Input()
  venue!: VenueModel;
  constructor(private route: ActivatedRoute, private router: Router) {
  }

  goToPage(){
    // this.route.url()
    //get page with
    // this.venue.id
  }
}
