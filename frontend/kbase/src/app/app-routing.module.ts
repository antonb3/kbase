import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppComponent} from "./app.component";
import {NewitemComponent} from "./newitem/newitem.component";
import {SearchpageComponent} from "./searchpage/searchpage.component";
import {AuthenticationGuard} from "./authentication.guard";
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: '', canActivate:[AuthenticationGuard],children: [
      {path: '', component: SearchpageComponent},
      {path: 'login', component: LoginComponent},
      {path: 'add', component: NewitemComponent},
      {path: '**', redirectTo: ''}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
