import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Product} from "../classes/Product";
import 'rxjs/Rx';



@Injectable()
export class ProductService{

    constructor(private _http:Http){}

    getAllProducts():Observable<Product[]>{
        let url:string = "/api/products/";

        return this._http.get(url).map(res => res.json());
    }

}
