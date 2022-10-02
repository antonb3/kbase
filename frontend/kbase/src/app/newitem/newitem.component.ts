import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

export interface Item {
  id?: number
  title?: string
  text?: string
}

@Component({
  selector: 'app-newitem',
  templateUrl: './newitem.component.html',
  styleUrls: ['./newitem.component.css']
})
export class NewitemComponent implements OnInit {

  itemTitle: string = "";
  itemText: string = "";

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit(): void {
  }

  add() {
    if (!this.itemTitle) return

    const newItem: Item = {
      title: this.itemTitle,
      text: this.itemText
    }

    this.http.post('http://localhost:9090/item/new',newItem)
      .subscribe(item => {
        this.router.navigate([''])
      })
  }

}
