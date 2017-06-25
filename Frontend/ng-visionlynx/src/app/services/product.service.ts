import {Injectable} from "@angular/core";
import {Http, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Product} from "../classes/Product";
import 'rxjs/Rx';
import {Info} from "../classes/Info";



@Injectable()
export class ProductService{

    constructor(private _http:Http){}

    /**GET**/

    getAllProducts():Observable<Product[]>{
        let url:string = "/api/allproducts/";

        return this._http.get(url).map(res => res.json());
    }

    getProductsByPage(page:number){
        let size:number = 5;
        let url:string = "/api/products/?page="+ page +"&size=" + size;

        return this._http.get(url).map(res => res.json());
    }

    getProductById(id:number){
        let url:string = "/api/products/" + id;

        return this._http.get(url).map(res => res.json());
    }

    getProductByName(name:string){
        let url:string = "/api/product/" + name;

        return this._http.get(url).map(res => res.json());
    }


    /**POST**/
    postProduct(data):Observable<Product>{
        let url:string = '/api/products/';

        let headers = new Headers({
            'Content-Type': 'application/json;charset=UTF-8'
        });
        let options = new RequestOptions({headers});

        return this._http.post(url, data, options).map(res => res.json());
    }

    /**PUT**/
    putProduct(id:number, data){
        let url:string = '/api/products/' + id;

        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});

        return this._http.put(url, data, options).map(res => res.json());
    }

    /** DELETE **/
    deleteProduct(id: number){
        let url:string = '/api/products/' + id;

        let headers = new Headers({
            'Content-Type': 'application/json;charset=UTF-8'
        });
        let options = new RequestOptions({headers});

        return this._http.delete(url, options).map(res => res.json());
    }

}
