import { Component, OnInit } from '@angular/core';
import {Info} from "app/classes/Info";
import {LoginService} from "../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: '../templates/login.component.html'
})
export class LoginComponent implements OnInit {

  constructor(private _loginService: LoginService, private _router: Router) { }

  ngOnInit() {
  }

  public logIn(event: any, user: string, pass: string):void{

      event.preventDefault();

      this._loginService.logIn(user, pass).subscribe(
          user => {
              console.log(Info.userInfo);
              console.log(Info.isAdminLogged);
              this._router.navigate(['/'])
          },
          error => alert("Invalid user or password")
      );

  }

}

