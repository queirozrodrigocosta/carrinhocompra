import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Carrinho } from '../../interfaces/carrinho';
import { UsuarioService } from 'src/app/services/usuario.service';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from 'src/app/interfaces/usuario';
import { Item } from 'src/app/interfaces/item';
import { ItemService } from 'src/app/services/item.service';
import { CarrinhoService } from 'src/app/services/carrinho.service';

@Component({
  selector: 'app-form-carrinho',
  templateUrl: './form-carrinho.component.html',
  styleUrls: ['./form-carrinho.component.css']
})

export class FormCarrinhoComponent {
  @Input() carrinho: Carrinho = <Carrinho>{};
  @Output() outputCarrinho: EventEmitter<Carrinho> = new EventEmitter();
  usuarios: Usuario[];
  itens: Item[];

  constructor(private usuarioService: UsuarioService,
    private itemService: ItemService,
    private carrinhoService: CarrinhoService,
    private activatedRoute: ActivatedRoute) {
      this.getUsuarios();
      this.getItens();
    }

    getItens() {
      this.itemService.getListaItems()
        .subscribe((itens: Item[]) => {
          if(this.carrinho.item)
            this.carrinho.item = itens.find(x => x.id == this.carrinho.item.id);
          this.itens = itens;
        }, (error) => { alert('Falha ao buscar itens. ' + error.error);  }); 
      } 
      
    getUsuarios() {
      this.usuarioService.getListaUsuarios()
        .subscribe((usuarios: Usuario[]) => {
          if(this.carrinho.usuario)
            this.carrinho.usuario = usuarios.find(x => x.id == this.carrinho.usuario.id);
          this.usuarios = usuarios;
        }, (error) => { alert('Falha ao buscar usuario. ' + error.error);  }); 
      }       

    onSubmit() {
      this.outputCarrinho.emit(this.carrinho);
    }

}
