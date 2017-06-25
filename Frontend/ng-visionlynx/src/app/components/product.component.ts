import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../classes/Product";
import {ProductService} from "../services/product.service";
import {Info} from "../classes/Info";
import {ShoppingCartService} from "../services/shoppingcart.service";
import {OrderCart} from "app/classes/OrderCart";


@Component({
    selector: 'app-product',
    templateUrl: '../templates/product.component.html'
})
export class ProductComponent implements OnInit {

    id:number;
    product: Product;
    isContactLens:boolean;
    globalInfo: Info;

    //Form values
    quantity = 1;
    sphere;
    radio;
    diameter;
    eye;

    constructor(private _route:ActivatedRoute, private _productService:ProductService,
        private _shoppingCart: ShoppingCartService, private _router: Router){
    }

    ngOnInit(){
        this.globalInfo = Info;
        this._route.params.subscribe(params => {
            this.id = +params['id'];
            console.log(this.id);
            this._productService.getProductById(this.id).subscribe(data => {
                this.product = data;
                this.isContactLens = this.product.type == "lentillas";
                console.log(this.product);
                console.log(this.isContactLens);
            })
        })

    }

    addToCart() {
        let data:OrderCart;

        data = new OrderCart;

        data.name = this.product.name;
        data.price = this.product.price;
        data.quantity = this.quantity;
        data.sphere = this.sphere;
        data.radio = this.radio;
        data.diameter = this.diameter;
        data.eye = this.eye;

        this._shoppingCart.postInProductList(data).subscribe(response => {
            Info.numberProducts += 1;
            this._router.navigateByUrl("/cart");
        })
    }

}

