import { Component, ViewChild } from '@angular/core';
import { CarrinhoService } from 'src/app/services/carrinho.service';
import { Router } from '@angular/router';
import { Carrinho } from 'src/app/interfaces/carrinho';

@Component({
  selector: 'app-criar-carrinho',
  templateUrl: './criar-carrinho.component.html',
  styleUrls: ['./criar-carrinho.component.css']
})
export class CriarCarrinhoComponent {

  constructor(private carrinhoService: CarrinhoService, private router: Router) { }

  addCarrinho(carrinho: Carrinho) {
    console.log(carrinho);
    this.carrinhoService.addCarrinho(carrinho)
      .subscribe(
        () => { alert('Salvo com sucesso.'); this.router.navigateByUrl('/carrinho/listar'); },
        (error) => { alert('Falha ao adicionar carrinho. ' + error.error);  });
  }

}
