import { Component, OnInit, ViewChild } from '@angular/core';
import { ItemService } from '../../../services/item.service';
import { Item } from '../../../interfaces/item';

@Component({
  selector: 'app-lista-item',
  templateUrl: './lista-item.component.html',
  styleUrls: ['./lista-item.component.css']
})
export class ListaItemComponent implements OnInit {
  public items: Item[];

  constructor(private itemService: ItemService) { }

  ngOnInit() {
    this.getListaItems();
  }

  getListaItems() {
    
    this.itemService.getListaItems()
      .subscribe((items: Item[]) => {
        this.items = items;
      }, (error) => { alert('Falha ao buscar items. ' + error.error);  });
  }

  deletaItem(id: string) {
    this.itemService.deletaItem(id)
      .subscribe(() => {
        alert('Excluido com sucesso.'); this.getListaItems();
      }, (error) => { alert('Falha ao deletar items. ' + error.error);  });
  }

  existemItems(): boolean {
    return this.items && this.items.length > 0;
  }

}
