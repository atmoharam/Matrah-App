import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginMainComponent} from "./Pages/login/login-main/login-main.component";
import {HomeMainComponent} from "./Pages/Home/home-main/home-main.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginMainComponent, HomeMainComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Matrah';
}
