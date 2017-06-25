import {RouterModule, Routes} from "@angular/router";
import {MainpageComponent} from "./components/mainpage.component";
import {NgModule} from "@angular/core";
import {LoginComponent} from "./components/login.component";
import {ProductComponent} from "./components/product.component";
import {CartComponent} from "./components/cart.component";
import {PaymentGateComponent} from "./components/paymentgate.component";
import {CreditCardComponent} from "./components/creditcard.component";
import {ProfileComponent} from "./components/profile.component";
import {OffersComponent} from "./components/offers.component";
import {AdminMenuComponent} from "./components/adminmenu.component";
import {AdminOrdersComponent} from "./components/adminorders.component";
import {AdminProductsComponent} from "./components/adminproducts.component";
import {AdminAddProduct} from "./components/adminaddproduct.component";
import {AdminImageProductComponent} from "./components/adminimageproduct.component";
import {RegisterComponent} from "./components/register.component";


const routes: Routes = [
    { path: '', redirectTo: '/index', pathMatch: 'full'},
    { path: 'index', component: MainpageComponent},
    { path: 'login', component: LoginComponent},
    { path: 'product/:id', component: ProductComponent},
    { path: 'cart', component: CartComponent},
    { path: 'paymentgate', component: PaymentGateComponent},
    { path: 'creditcardpayment', component: CreditCardComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'offers', component: OffersComponent},
    { path: 'adminmenu', component: AdminMenuComponent},
    { path: 'adminorders', component: AdminOrdersComponent},
    { path: 'adminproducts', component: AdminProductsComponent},
    { path: 'adminadd/:id', component: AdminAddProduct},
    { path: 'adminproductimage/:id', component: AdminImageProductComponent},
    { path: 'register', component: RegisterComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {
}


