import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppComponent} from "./app.component";
import {NewitemComponent} from "./newitem/newitem.component";
import {SearchpageComponent} from "./searchpage/searchpage.component";

const routes: Routes = [
  {path: '', component: SearchpageComponent},
  {path: 'add', component: NewitemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
