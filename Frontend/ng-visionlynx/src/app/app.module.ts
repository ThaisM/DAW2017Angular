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
import {AdminMenuComponent} from "./components/adminmenu.component";
import {AdminOrdersComponent} from "./components/adminorders.component";
import {AdminProductsComponent} from "app/components/adminproducts.component";
import {AdminAddProduct} from "app/components/adminaddproduct.component";
import {AdminImageProductComponent} from "./components/adminimageproduct.component";
import {NgUploaderModule} from "ngx-uploader/src/module/ngx-uploader.module";
import {RegisterComponent} from "./components/register.component";

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
        OffersComponent,
        AdminMenuComponent,
        AdminOrdersComponent,
        AdminProductsComponent,
        AdminAddProduct,
        AdminImageProductComponent,
        RegisterComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpModule,
        NgUploaderModule

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
