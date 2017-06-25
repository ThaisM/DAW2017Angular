import { Component, OnInit } from '@angular/core';
import {OrderSummary} from "app/classes/OrderSummary";
import {ShoppingCartService} from "../services/shoppingcart.service";
import {OfferService} from "../services/offer.service";

@Component({
    selector: 'app-adminorders',
    templateUrl: '../templates/adminorders.component.html'
})

export class AdminOrdersComponent implements OnInit {

    orders: OrderSummary[];
    pagenumber:number;
    pagesize:number;
    hideMoreButton: boolean;

    constructor(private shoppingService:ShoppingCartService){
        this.pagenumber = 0;
        this.pagesize = 5;
        this.orders = [];
    }

    ngOnInit(){
        this.shoppingService.getOrdersByPage(this.pagenumber, this.pagesize).subscribe(data => {
            this.orders.push.apply(this.orders, data);
            this.pagenumber++;
            console.log(this.orders)
        })
    }

    loadMore(){
        this.shoppingService.getOrdersByPage(this.pagenumber, this.pagesize).subscribe(data => {
            if(data.length == 0){
                console.log(data);
                this.hideMoreButton = true;
            }
            else{
                this.orders.push.apply(this.orders, data);
                this.pagenumber++;
            }
        })
    }



}
