import {Component, OnInit} from '@angular/core';
import {LoginRequest, LoginResponse} from "../model/login-models";
import {LoginServiceService} from "../service/login-service.service";
import {response} from "express";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-main',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login-main.component.html',
  styleUrl: './login-main.component.css'
})
export class LoginMainComponent implements OnInit{

  loginF:boolean = true;

  loginForm = new FormGroup({
  username: new FormControl('Ahmed Owner Test', [Validators.required]),
  password: new FormControl('ahmed123', [Validators.required])
  })

  registerForm = new FormGroup({

  })

  response : LoginResponse ={id: 0, role: "", token: "", username: ""};
  constructor(private loginService:LoginServiceService) {
  }
    ngOnInit(): void {

    }

    login():void{
      this.loginService.login(<LoginRequest>this.loginForm.value).subscribe(
        response =>
          console.log(this.response = response));
    }

    swichForm():void{
    this.loginF = !this.loginF;
    }

}
