import {RouterModule, Routes} from "@angular/router";
import {MainpageComponent} from "./components/mainpage.component";
import {NgModule} from "@angular/core";
import {LoginComponent} from "./components/login.component";


const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full'},
  { path: 'index', component: MainpageComponent},
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}


