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
import {ProductComponent} from "./components/product.component";
import {ShoppingCartService} from "./services/shoppingcart.service";
import {CartComponent} from "./components/cart.component";
import {UserService} from "./services/user.service";
import {OfferService} from "./services/offer.service";
import {PaymentGateComponent} from "./components/paymentgate.component";
import {CreditCardComponent} from "./components/creditcard.component";
import {ProfileComponent} from "./components/profile.component";
import {OffersComponent} from "./components/offers.component";

@NgModule({
    declarations: [
        AppComponent,
        MainpageComponent,
        LoginComponent,
        ProductComponent,
        CartComponent,
        PaymentGateComponent,
        CreditCardComponent,
        ProfileComponent,
        OffersComponent
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
        ProductService,
        ShoppingCartService,
        UserService,
        OfferService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
