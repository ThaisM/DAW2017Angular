import {Injectable} from "@angular/core";
import { Http, RequestOptions, Headers } from '@angular/http';

@Injectable()
export class OfferService{

    constructor(private _http:Http){}

    getOffers() {
        let url: string = "/api/offers/";

        return this._http.get(url).map(res => res.json());
    }
}
