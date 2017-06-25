import { Component } from '@angular/core';
import {Info} from "app/classes/Info";
import {LoginService} from "./services/login.service";
import {Router} from "@angular/router";
import {ProductService} from "./services/product.service";
import {Product} from "./classes/Product";

@Component({
    selector: 'app-root',
    templateUrl: './templates/nav.html'
})
export class AppComponent {

    globalInfo: Info;
    products: Product[];
    numberProducts:number;

    constructor(private _loginService: LoginService, private router: Router,
        private _productService: ProductService){

    }

    ngOnInit(){
        this.globalInfo = Info;
        this._productService.getAllProducts().subscribe(data => {
            this.products = data;
        }, error => {
            console.log(error);
        })
        this._loginService.reqIsLogged();
        this.numberProducts = Info.numberProducts;
    }

    logOut(){
        this._loginService.logOut().subscribe(
            response => {
                Info.userInfo = null;
                Info.isAdminLogged = false;
                this.router.navigate(['/index']);
            },
        error => {
            Info.userInfo = null;
            Info.isAdminLogged = false;
        }

        );
    }



}
