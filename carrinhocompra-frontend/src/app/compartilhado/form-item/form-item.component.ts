import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Item } from '../../interfaces/item';

@Component({
  selector: 'app-form-item',
  templateUrl: './form-item.component.html',
  styleUrls: ['./form-item.component.css']
})
export class FormItemComponent {
  @Input() item: Item = <Item>{};
  @Output() outputItem: EventEmitter<Item> = new EventEmitter();

  onSubmit() {
    this.outputItem.emit(this.item);
  }

}
