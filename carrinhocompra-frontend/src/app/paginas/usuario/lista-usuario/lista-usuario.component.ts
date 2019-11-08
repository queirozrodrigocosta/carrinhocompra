import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from '../../../interfaces/usuario';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css']
})
export class ListaUsuarioComponent implements OnInit {
  public usuarios: Usuario[];

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.getListaUsuarios();
  }

  getListaUsuarios() {
    
    this.usuarioService.getListaUsuarios()
      .subscribe((usuarios: Usuario[]) => {
        this.usuarios = usuarios;
      }, (error) => { alert('Falha ao buscar usuarios. ' + error.error);  });
  }

  deletaUsuario(id: string) {
    this.usuarioService.deletaUsuario(id)
      .subscribe(() => {
        alert('Excluido com sucesso.'); this.getListaUsuarios();
      }, (error) => { alert('Falha ao deletar usuarios. ' + error.error);  });
  }

  existemUsuarios(): boolean {
    return this.usuarios && this.usuarios.length > 0;
  }

}
