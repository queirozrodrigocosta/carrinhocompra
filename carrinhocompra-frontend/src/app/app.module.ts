import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaUsuarioComponent } from './paginas/usuario/lista-usuario/lista-usuario.component';
import { FormUsuarioComponent } from './compartilhado/form-usuario/form-usuario.component';
import { CriarUsuarioComponent } from './paginas/usuario/criar-usuario/criar-usuario.component';
import { EditarUsuarioComponent } from './paginas/usuario/editar-usuario/editar-usuario.component';
import { ListaItemComponent } from './paginas/item/lista-item/lista-item.component';
import { FormItemComponent } from './compartilhado/form-item/form-item.component';
import { CriarItemComponent } from './paginas/item/criar-item/criar-item.component';
import { EditarItemComponent } from './paginas/item/editar-item/editar-item.component';
import { ListaCarrinhoComponent } from './paginas/carrinho/lista-carrinho/lista-carrinho.component';
import { FormCarrinhoComponent } from './compartilhado/form-carrinho/form-carrinho.component';
import { CriarCarrinhoComponent } from './paginas/carrinho/criar-carrinho/criar-carrinho.component';
import { EditarCarrinhoComponent } from './paginas/carrinho/editar-carrinho/editar-carrinho.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaCarrinhoComponent,
    FormCarrinhoComponent,
    CriarCarrinhoComponent,
    EditarCarrinhoComponent,     
    ListaUsuarioComponent,
    FormUsuarioComponent,
    CriarUsuarioComponent,
    EditarUsuarioComponent,    
    ListaItemComponent,
    FormItemComponent,
    CriarItemComponent,
    EditarItemComponent        
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
