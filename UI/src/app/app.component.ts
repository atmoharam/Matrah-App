import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginMainComponent} from "./Pages/login/login-main/login-main.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginMainComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Matrah';
}
