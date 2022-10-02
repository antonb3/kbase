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

  constructor() { }

  ngOnInit(): void {
  }

}
