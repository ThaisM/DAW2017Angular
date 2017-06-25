import { Component, OnInit } from '@angular/core';
import {Product} from "../classes/Product";
import {ProductService} from "../services/product.service";
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
    selector: 'app-addproduct',
    templateUrl: '../templates/adminaddproduct.html'
})

export class AdminAddProduct implements OnInit {

    product: Product;
    id:any;

    constructor(private _productService:ProductService, private _router: Router, private _route:ActivatedRoute){
        this.product = new Product;
    }

    ngOnInit(){
        this._route.params.subscribe(params => {
            if(params['id'] != 'add'){
                this._productService.getProductById(params['id']).subscribe(data => {
                    this.product = data;
                    console.log(this.product);
                })
            }
        })

    }

    postProduct(){
        if(this.product.subtype == 'Marca'){
            this.product.type = 'gafas de sol';
        }
        else if(this.product.subtype == 'Accesorios' || this.product.subtype == 'Liquidos'){
            this.product.type = 'liquidosyaccesorios';
        }
        else{
            this.product.type = 'lentillas';
        }
        this._productService.postProduct(this.product).subscribe(data => {
            this._router.navigateByUrl('/adminproducts');
        })
    }


}
