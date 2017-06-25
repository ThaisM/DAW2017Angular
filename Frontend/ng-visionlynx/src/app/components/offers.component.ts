import { Component, OnInit } from '@angular/core';
import {OfferService} from "../services/offer.service";
import {Offer} from "app/classes/Offer";
import {getRandomString} from "selenium-webdriver/safari";
import {Product} from "../classes/Product";

@Component({
    selector: 'app-offers',
    templateUrl: '../templates/offers.component.html'
})
export class OffersComponent implements OnInit {

    offers:Offer[];
    cribbedOffer:Product[];
    indexSelected:number[];

    constructor(private _offerService: OfferService){}

    ngOnInit(){
        this.offers = [];
        this.cribbedOffer = [];
        this.indexSelected = [];

        this._offerService.getOffers().subscribe(offersRes => {
            this.offers = offersRes;
            console.log(this.offers);
            for(let i = 0; i < 3; i++) {
                let index = this.getRandomInt(0, this.offers.length - 1);
                if (this.indexSelected.indexOf(index) == -1) {
                    this.indexSelected.push(index);
                    this.cribbedOffer.push(this.offers[index].product);
                    console.log(this.cribbedOffer);
                }
                else{
                    i--;
                }
            }
        })
    }

    getRandomInt(min:number, max:number):number {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

}
