import { Component, OnInit } from '@angular/core';
import {Info} from "../classes/Info";
import {ShoppingCartService} from "../services/shoppingcart.service";
import {OrderSummary} from "../classes/OrderSummary";
import {Router} from "@angular/router";


@Component({
    selector: 'app-cart',
    templateUrl: '../templates/creditcard.component.html'
})

export class CreditCardComponent implements OnInit {

    globalInfo:Info;
    numPedido: number;
    actualDate: string;
    actualTime: string;
    pagado: boolean;

    constructor(private _shoppingcartService: ShoppingCartService,
                private _router: Router){}

    ngOnInit(){
        this.globalInfo = Info;
        this.numPedido = this.getRandomInt(0, 9999999);
        this.actualDate = this.getActualDate();
        this.actualTime = this.getActualTime();
    }

    getRandomInt(min:number, max:number):number {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    getActualDate():string{
        var today = new Date();
        var dd:any;
        var mm:any;
        var yyyy = today.getFullYear();

        if(today.getDate()<10) {
            dd = '0'+dd
        }
        else{
            dd = today.getDate();
        }

        if(today.getMonth() + 1 < 10) {
            mm = '0'+ (today.getMonth() +1)
        }
        else{
            mm = today.getMonth() + 1;
        }

        return dd + '/' + mm + '/' + yyyy;
    }

    getActualTime(){
        var date = new Date();

        var hh:any;
        var mm:any;

        if(date.getHours() < 10){
            hh = '0' + date.getHours();
        }
        else{
            hh = date.getHours();
        }

        if(date.getMinutes() < 10){
            mm = '0' + date.getMinutes();
        }
        else{
            mm = date.getMinutes();
        }

        return hh + ":" + mm;
    }

    pay(){
        let orderSummary = new OrderSummary();
        orderSummary.ordername = "Normal Order"
        orderSummary.paymentmethod = "option1,card"
        orderSummary.user = Info.userInfo.name;
        orderSummary.totalprice = Info.actualPrice;
        orderSummary.state = "ordered";
        this._shoppingcartService.postOrderSummary(orderSummary).subscribe(response => {
            console.log(response);
            this.pagado = true;
            Info.numberProducts = 0;
            window.setTimeout(() => {
                this._router.navigate(['/']);
            }, 5000);

        })
    }

}


