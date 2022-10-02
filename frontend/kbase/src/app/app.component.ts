import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Item {
  id?: number
  title?: string
  text?: string
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  searchtext: string = "";
  items: Array<any> = []

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<Item[]>('http://localhost:9090/item/last')
      .subscribe(items => {
        this.items = items
      })
  }

  search() {
    this.http.get<Item[]>('http://localhost:9090/item/find?text='+this.searchtext)
      .subscribe(items => {
        this.items = items
      })
  }
}
