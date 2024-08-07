import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import {AuthInterceptor} from "../../common/Interceptor/auth.interceptor";


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HomeRoutingModule,
  ],
  providers:[AuthInterceptor],
})
export class HomeModule { }
