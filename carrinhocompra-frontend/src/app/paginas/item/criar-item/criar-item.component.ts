import { Component, ViewChild } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';
import { Router } from '@angular/router';
import { Item } from 'src/app/interfaces/item';

@Component({
  selector: 'app-criar-item',
  templateUrl: './criar-item.component.html',
  styleUrls: ['./criar-item.component.css']
})
export class CriarItemComponent {

  constructor(private itemService: ItemService, private router: Router) { }

  addItem(item: Item) {
    this.itemService.addItem(item)
      .subscribe(
        () => { alert('Salvo com sucesso.'); this.router.navigateByUrl('/item/listar'); },
        (error) => { alert('Falha ao adicionar item. ' + error.error);  });
  }

}
