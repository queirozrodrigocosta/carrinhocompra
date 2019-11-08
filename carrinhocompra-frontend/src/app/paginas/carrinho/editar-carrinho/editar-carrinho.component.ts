import { Component, ViewChild } from '@angular/core';
import { CarrinhoService } from '../../../services/carrinho.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Carrinho } from '../../../interfaces/carrinho';
import { error } from 'util';

@Component({
  selector: 'app-editar-carrinho',
  templateUrl: './editar-carrinho.component.html',
  styleUrls: ['./editar-carrinho.component.css']
})
export class EditarCarrinhoComponent {
  public carrinho: Carrinho = <Carrinho>{};

  constructor(private carrinhoService: CarrinhoService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
      this.getCarrinho(this.activatedRoute.snapshot.params.id);
    }

    getCarrinho(id: string) {
      this.carrinhoService.getCarrinho(id)
        .subscribe((carrinho: Carrinho) => {
          this.carrinho = carrinho;
        }, (error) => { alert('Falha ao buscar carrinho. ' + error.error);  }); 
    }

    atualizaCarrinho(carrinho: Carrinho) {
      console.log(carrinho);
      this.carrinhoService.atualizaCarrinho(carrinho)
        .subscribe(
          () => { alert('Salvo com sucesso.'); this.router.navigateByUrl('/carrinho/listar'); },
          (error) => { alert('Falha ao atualizar carrinho. ' + error.error); });
    }

}
