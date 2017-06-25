import { Component, OnInit } from '@angular/core';
import {Product} from "../classes/Product";
import {ProductService} from "../services/product.service";

@Component({
    selector: 'app-adminproducts',
    templateUrl: '../templates/adminproducts.component.html'
})

export class AdminProductsComponent implements OnInit {

    products: Product[];
    pagenumber:number;
    pagesize:number;
    hideMoreButton: boolean;

    constructor(private _productService: ProductService){
        this.pagenumber = 0;
        this.pagesize = 5;
        this.products = [];
    }

    ngOnInit(){
        this._productService.getProductsByPage(this.pagenumber).subscribe(data => {
            this.products.push.apply(this.products, data);
            this.pagenumber++;
            console.log(this.products);
        })
    }

    loadMore(){
        this._productService.getProductsByPage(this.pagenumber).subscribe(data => {
            if(data.length == 0){
                console.log(data);
                this.hideMoreButton = true;
            }
            else{
                this.products.push.apply(this.products, data);
                this.pagenumber++;
            }
        })
    }

    deleteProduct(id:number){
        this._productService.deleteProduct(id).subscribe(data => {
            let finalPage = this.pagenumber;
            this.pagenumber = 0;
            this.products = [];
            this.ngOnInit();
            for(let i = 1; i < finalPage; i++){
                this.loadMore();
            }
        })
    }

}
