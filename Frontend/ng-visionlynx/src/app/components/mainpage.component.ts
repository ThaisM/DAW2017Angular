import { Component, OnInit } from '@angular/core';
import {Product} from "../classes/Product";
import {Router} from "@angular/router";
import {ProductService} from "../services/product.service";

@Component({
  selector: 'app-mainpage',
  templateUrl: '../templates/mainpage.component.html'
})
export class MainpageComponent implements OnInit {

    bestProducts: Product[] = [];

  constructor(private router: Router, private _productService: ProductService){}

  ngOnInit() {
      this._productService.getAllProducts().subscribe(data => {
          let products:Product[] = data;
          this.bestProducts = products.slice(0);
          this.bestProducts.sort((a, b) => Product.compare(a, b));
          console.log(this.bestProducts);
      }, error => {
          console.log(error);
      })
  }

}
