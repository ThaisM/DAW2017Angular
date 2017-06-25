import { Component, OnInit } from '@angular/core';
import {Info} from "../classes/Info";
import {User} from "../classes/User";
import {UserService} from "../services/user.service";

@Component({
    selector: 'app-profile',
    templateUrl: '../templates/profile.component.html'
})

export class ProfileComponent implements OnInit {

    user:User;
    modifiedUser: boolean;
    modifiedPassword: boolean;
    passwordDontMatch: boolean;

    /* PASSWORDS CHANGE */
    password1:string;
    password2:string;

    constructor(private _userService: UserService){

    }

    ngOnInit(){
        this._userService.getUserLogged().subscribe(data => {
            this.user = data;
            Info.userInfo = this.user;
        })
    }

    modifyUser(){
        this._userService.putProduct(this.user.id, this.user).subscribe(data => {
           this.modifiedUser = true;
           this.ngOnInit();
            window.setTimeout(() => {
                this.modifiedUser = false;
            }, 5000);
        });
    }

    changePassword(){
        if(this.password1 == null || this.password2 == null || this.password1 != this.password2){
            this.passwordDontMatch = true;
        }
        else{
            this._userService.putPassword(this.user.id, this.password1).subscribe(data => {
                this.passwordDontMatch = false;
                this.modifiedPassword = true;
                window.setTimeout(() => {
                    this.modifiedPassword = false;
                    this.passwordDontMatch = false;
                }, 5000);
            })
        }
    }

}
