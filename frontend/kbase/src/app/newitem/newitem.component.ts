import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {COMMA, ENTER} from "@angular/cdk/keycodes";
import {FormControl, FormGroup} from "@angular/forms";
import {MatChipInputEvent} from "@angular/material/chips";

export interface Item {
  id?: number
  title?: string
  text?: string
  tags?: string[]
}

@Component({
  selector: 'app-newitem',
  templateUrl: './newitem.component.html',
  styleUrls: ['./newitem.component.css']
})
export class NewitemComponent implements OnInit {

  itemTitle: string = "";
  itemText: string = "";

  //chips+
  addOnBlur = true;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  tags: string[] = [];

  addTag(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    // Add our tag
    if (value) {
      this.tags.push(value);
    }

    // Clear the input value
    event.chipInput!.clear();
  }

  remove(tag: string): void {
    const index = this.tags.indexOf(tag);

    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }
  //chips-

  constructor(private http: HttpClient,private router: Router) {}

  ngOnInit(): void {
  }

  add() {
    const newItem: Item = {
      title: this.itemTitle,
      text: this.itemText,
      tags: this.tags
    }

    this.http.post('/api/item/new',newItem)
      .subscribe(item => {
        this.router.navigate([''])
      })
  }

}
