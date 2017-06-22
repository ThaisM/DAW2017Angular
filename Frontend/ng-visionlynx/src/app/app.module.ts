import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainpageComponent } from './components/mainpage.component';
import {AppRoutingModule} from "./app-routing.module";
import {APP_BASE_HREF} from "@angular/common";
import {LoginComponent} from "./components/login.component";
import {LoginService} from "./services/login.service";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {ProductService} from "./services/product.service";

@NgModule({
    declarations: [
        AppComponent,
        MainpageComponent,
        LoginComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpModule

    ],
    providers: [
        {provide: APP_BASE_HREF, useValue: '/'},
        LoginService,
        ProductService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
