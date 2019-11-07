import { Component, OnInit, ViewChild } from '@angular/core';
import { CarrinhoService } from '../../../services/carrinho.service';
import { Carrinho } from '../../../interfaces/carrinho';
import { Usuario } from 'src/app/interfaces/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-lista-carrinho',
  templateUrl: './lista-carrinho.component.html',
  styleUrls: ['./lista-carrinho.component.css']
})
export class ListaCarrinhoComponent implements OnInit {
  public carrinhos: Carrinho[];
  public usuarios: Usuario[] = [];

  constructor(private carrinhoService: CarrinhoService,     private usuarioService: UsuarioService
    ) { }

  ngOnInit() {
    this.getListaCarrinhos();
  }


  getListaCarrinhos() {
    
    this.carrinhoService.getListaCarrinhos()
      .subscribe((carrinhos: Carrinho[]) => {
        carrinhos.forEach((obj) => {
          if (this.usuarios.findIndex(x => x.id == obj.usuario.id)) {
            obj.usuario.total = obj.item.valor * obj.quantidade;
            this.usuarios.push(obj.usuario);
          } else
          this.usuarios.find(x => x.id == obj.usuario.id).total += obj.item.valor * obj.quantidade;

        });

          this.carrinhos = carrinhos;
      }, (error) => { alert('Falha ao buscar carrinhos. ' + error.error);  });
  }

  deletaCarrinho(id: string) {
    this.carrinhoService.deletaCarrinho(id)
      .subscribe(() => {
        alert('Excluido com sucesso.'); this.getListaCarrinhos();
      }, (error) => { alert('Falha ao deletar carrinhos. ' + error.error);  });
  }

  existemCarrinhos(): boolean {
    return this.carrinhos && this.carrinhos.length > 0;
  }

}
