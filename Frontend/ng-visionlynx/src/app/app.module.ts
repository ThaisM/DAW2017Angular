import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainpageComponent } from './components/mainpage.component';
import {AppRoutingModule} from "./app-routing.module";
import {APP_BASE_HREF} from "@angular/common";
import {LoginComponent} from "./components/login.component";

@NgModule({
  declarations: [
    AppComponent,
    MainpageComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [{provide: APP_BASE_HREF, useValue: '/'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
