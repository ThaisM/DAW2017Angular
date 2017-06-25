import { Component, OnInit } from '@angular/core';
import {User} from "../classes/User";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-register',
    templateUrl: '../templates/register.component.html'
})

export class RegisterComponent implements OnInit {

    user:User;

    constructor(private _userService: UserService, private _router: Router){
        this.user = new User;
    }

    ngOnInit(){

    }

    register(name:string){
        console.log(this.user);
        this._userService.postUser(this.user).subscribe(data => {
            this._router.navigateByUrl('/login');
        })
    }

}
