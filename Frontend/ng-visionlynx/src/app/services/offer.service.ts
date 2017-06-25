import {Injectable} from "@angular/core";
import { Http, RequestOptions, Headers } from '@angular/http';

@Injectable()
export class OfferService{

    constructor(private _http:Http){}

    getOffers() {
        let url: string = "/api/offers/";

        return this._http.get(url).map(res => res.json());
    }

    getOffersByPage(page:number, size:number){
        let url: string = "/api/offersPage/?page=" +page + "&size=" + size;

        return this._http.get(url).map(res => res.json());
    }
}
