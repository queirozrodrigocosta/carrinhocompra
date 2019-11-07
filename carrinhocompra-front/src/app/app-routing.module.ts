import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaUsuarioComponent } from './paginas/usuario/lista-usuario/lista-usuario.component';
import { CriarUsuarioComponent } from './paginas/usuario/criar-usuario/criar-usuario.component';
import { EditarUsuarioComponent } from './paginas/usuario/editar-usuario/editar-usuario.component';
import { ListaItemComponent } from './paginas/item/lista-item/lista-item.component';
import { CriarItemComponent } from './paginas/item/criar-item/criar-item.component';
import { EditarItemComponent } from './paginas/item/editar-item/editar-item.component';
import { ListaCarrinhoComponent } from './paginas/carrinho/lista-carrinho/lista-carrinho.component';
import { CriarCarrinhoComponent } from './paginas/carrinho/criar-carrinho/criar-carrinho.component';
import { EditarCarrinhoComponent } from './paginas/carrinho/editar-carrinho/editar-carrinho.component';


const routes: Routes = [
  { path: '', component: ListaUsuarioComponent},
  { path: 'usuario/listar', component: ListaUsuarioComponent},
  { path: 'usuario/criar', component: CriarUsuarioComponent},
  { path: 'usuario/editar/:id', component: EditarUsuarioComponent},
  { path: 'carrinho/listar', component: ListaCarrinhoComponent},
  { path: 'carrinho/criar', component: CriarCarrinhoComponent},
  { path: 'carrinho/editar/:id', component: EditarCarrinhoComponent},  
  { path: 'item/listar', component: ListaItemComponent},
  { path: 'item/criar', component: CriarItemComponent},
  { path: 'item/editar/:id', component: EditarItemComponent},  
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
