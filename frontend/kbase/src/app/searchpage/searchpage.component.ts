import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Item {
  id?: number
  title?: string
  text?: string
}

@Component({
  selector: 'app-searchpage',
  templateUrl: './searchpage.component.html',
  styleUrls: ['./searchpage.component.css']
})
export class SearchpageComponent implements OnInit {

  searchtext: string = "";
  items: Array<any> = []

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<Item[]>('/api/item/last')
      .subscribe(items => {
        this.items = items
      })
  }

  search() {
    this.http.get<Item[]>('/api/item/find?text='+this.searchtext)
      .subscribe(items => {
        this.items = items
      })
  }
}
