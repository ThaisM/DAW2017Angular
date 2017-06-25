import {Injectable} from "@angular/core";
import { Http, RequestOptions, Headers } from '@angular/http';
import {Info} from "../classes/Info";
import 'rxjs/Rx';
import {ShoppingCartService} from "./shoppingcart.service";

@Injectable()
export class LoginService{

    constructor(private http: Http, private _shoppingCart: ShoppingCartService){
        this.reqIsLogged();
    }

    reqIsLogged(){

        let headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'
        });

        let options = new RequestOptions({headers});

        this.http.get('/api/logIn', options).subscribe(
            response => this.processLogInResponse(response),
            error => {
                if(error.status != 401){
                    console.error("Error when asking if logged: "+
                        JSON.stringify(error));
                }
            }
        );
    }

    private processLogInResponse(response){
        Info.userInfo = response.json();
        Info.isAdminLogged = Info.userInfo.roles.indexOf("ROLE_ADMIN") !== -1;
        this._shoppingCart.getProductsList().subscribe(cart => {
            Info.numberProducts = cart.length;
        })
    }

    logIn(user: string, pass: string) {

        let userPass = user + ":" + pass;

        let headers = new Headers({
            'Authorization': 'Basic '+utf8_to_b64(userPass),
            'X-Requested-With': 'XMLHttpRequest'
        });

        let options = new RequestOptions({headers});

        return this.http.get('/api/logIn', options).map(
            response => {
                this.processLogInResponse(response);
                return Info.userInfo;
            }
        );
    }

    logOut(){

        return this.http.get('/api/logOut').map(
            response => {
                Info.isAdminLogged= false;
                Info.userInfo = null;
                return response;
            }
        );
    }
}

function utf8_to_b64(str) {
    return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function(match, p1) {
        return String.fromCharCode(<any>'0x' + p1);
    }));
}
