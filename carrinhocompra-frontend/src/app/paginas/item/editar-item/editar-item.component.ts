import { Component, ViewChild } from '@angular/core';
import { ItemService } from '../../../services/item.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../../../interfaces/item';
import { error } from 'util';

@Component({
  selector: 'app-editar-item',
  templateUrl: './editar-item.component.html',
  styleUrls: ['./editar-item.component.css']
})
export class EditarItemComponent {
  public item: Item = <Item>{};

  constructor(private itemService: ItemService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
      this.getItem(this.activatedRoute.snapshot.params.id);
    }

    getItem(id: string) {
      this.itemService.getItem(id)
        .subscribe((item: Item) => {
          this.item = item;
        }, (error) => { alert('Falha ao buscar item. ' + error.error);  }); 
    }

    atualizaItem(item: Item) {
      console.log(item);
      this.itemService.atualizaItem(item)
        .subscribe(
          () => { alert('Salvo com sucesso.'); this.router.navigateByUrl('/item/listar'); },
          (error) => { alert('Falha ao atualizar item. ' + error.error); });
    }

}
