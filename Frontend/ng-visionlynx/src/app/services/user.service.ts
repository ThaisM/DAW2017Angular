import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RequestOptions, Http, Headers} from "@angular/http";
import {User} from "../classes/User";
import {Info} from "../classes/Info";

@Injectable()
export class UserService{

    constructor(private _http:Http){}

    postUser(data):Observable<User>{
        let url:string = '/api/users/';

        let headers = new Headers({
            'Content-Type': 'application/json;charset=UTF-8'
        });
        let options = new RequestOptions({headers});

        return this._http.post(url, data, options).map(res => res.json());
    }

    getUserLogged():Observable<User>{
        let url:string = "/api/loggedUser/";

        return this._http.get(url).map(res => res.json());
    }

    putPassword(id:number, password:string):Observable<String>{
        let url:string = '/api/users/changePassword/' + id;

        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});

        return this._http.put(url, password, options).map(res => res.toString());
    }

    putProduct(id:number, data){
        let url:string = '/api/users/' + id;

        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});

        return this._http.put(url, data, options).map(res => res.json());
    }

}
