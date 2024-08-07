import {Component, OnInit} from '@angular/core';
import {LoginRequest, LoginResponse} from "../model/login-models";
import {LoginServiceService} from "../service/login-service.service";
import {response} from "express";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {RegisterRequest} from "../model/register-models";
import {LocalStorageService} from "../../../common/LocalStorage/local-storage.service";

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
  username: new FormControl('', [Validators.required]),
  password: new FormControl('', [Validators.required])
  })

  registerForm = new FormGroup({
    userName: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    role: new FormControl('', Validators.required),
  })

  response : LoginResponse ={id: 0, role: "", token: "", username: ""};
  constructor(private loginService:LoginServiceService, private localStorageService : LocalStorageService) {
  }
    ngOnInit(): void {

    }

    login():void{
      this.loginService.login(<LoginRequest>this.loginForm.value).subscribe(
        response =>
      this.localStorageService.setItem("user-data", response));
    }

    register():void{
    this.loginService.register(<RegisterRequest>this.registerForm.value).subscribe(
      response =>
      this.localStorageService.setItem("user-data", response)
    )
    }

    switchForm():void{
    this.loginF = !this.loginF;
    }

}
