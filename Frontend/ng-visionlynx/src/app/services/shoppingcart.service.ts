import {Injectable} from "@angular/core";
import {Http, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/Rx';
import {OrderCart} from "../classes/OrderCart";
import {Product} from "../classes/Product";
import {OrderSummary} from "../classes/OrderSummary";
import {Info} from "../classes/Info";



@Injectable()
export class ShoppingCartService{

    constructor(private _http:Http){}

    /**GET**/

    getProductsList():Observable<OrderCart[]>{
        let url:string = "/api/listcart/";

        return this._http.get(url).map(res => res.json());
    }

    getAllOrders():Observable<OrderSummary[]>{
        let url:string = "/api/orders/";

        return this._http.get(url).map(res => res.json());
    }

    getOrdersByPage(page:number, size:number):Observable<OrderSummary[]>{
        let url:string = "/api/orders/?page=" + page + "&size=" + size;

        return this._http.get(url).map(res => res.json());
    }

    /**POST**/

    postInProductList(data):Observable<String>{
        let url:string = '/api/cart/addList/';

        let headers = new Headers({
            'Content-Type': 'application/json;charset=UTF-8'
        });

        let options = new RequestOptions({headers});

        return this._http.post(url, data, options).map(res => res.toString());
    }

    postOrderSummary(data):Observable<OrderSummary>{
        let url:string = '/api/orders/';

        let headers = new Headers({
            'Content-Type': 'application/json;charset=UTF-8'
        });

        let options = new RequestOptions({headers});

        return this._http.post(url, data, options).map(res => res.json());
    }



    /**PUT**/

    /** DELETE **/

    removeInProductList(name: string):Observable<String>{
        let url:string = '/api/cart/remove/' + name;

        let headers = new Headers({
            'Content-Type': 'application/json;charset=UTF-8'
        });
        let options = new RequestOptions({headers});

        return this._http.delete(url, options).map(res => res.toString());
    }


}

