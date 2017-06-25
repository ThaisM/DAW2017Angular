import { Component, OnInit } from '@angular/core';
import {Info} from "app/classes/Info";
import {LoginService} from "../services/login.service";
import {OrderCart} from "../classes/OrderCart";
import {ShoppingCartService} from "../services/shoppingcart.service";
import {Product} from "../classes/Product";
import {ProductService} from "../services/product.service";

@Component({
    selector: 'app-cart',
    templateUrl: '../templates/cart.component.html'
})

export class CartComponent implements OnInit {

    listProducts: OrderCart[];
    productsObjects: Product[];
    globalInfo:Info = Info;

    constructor(private _shoppingCart: ShoppingCartService, private _loginService: LoginService,
        private _productService: ProductService){
    }

    ngOnInit(){
        this.productsObjects = [];
        this.listProducts = [];
        Info.comission = 5;
        Info.actualPrice = Info.comission;
        this._loginService.reqIsLogged();
        this._shoppingCart.getProductsList().subscribe(data => {
            this.listProducts = data;
            console.log(this.listProducts)
            for(let i = 0; i <this.listProducts.length; i++){
                let nameProduct:string = this.listProducts[i].name;
                Info.actualPrice += this.listProducts[i].quantity * this.listProducts[i].price;
                this._productService.getProductByName(nameProduct).subscribe(productInfo => {
                    this.productsObjects.push(productInfo);
                })
            }
        });
    }

    deleteOrder(name: string) {
        this._shoppingCart.removeInProductList(name).subscribe(data => {
            console.log("Borrado");
            Info.numberProducts -= 1;
            this.ngOnInit();
        })
    }

}
