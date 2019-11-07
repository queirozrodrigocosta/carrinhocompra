import { Component, ViewChild } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../../../interfaces/usuario';
import { error } from 'util';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent {
  public usuario: Usuario = <Usuario>{};

  constructor(private usuarioService: UsuarioService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
      this.getUsuario(this.activatedRoute.snapshot.params.id);
    }

    getUsuario(id: string) {
      this.usuarioService.getUsuario(id)
        .subscribe((usuario: Usuario) => {
          this.usuario = usuario;
        }, (error) => { alert('Falha ao buscar usuario. ' + error.error);  }); 
    }

    atualizaUsuario(usuario: Usuario) {
      console.log(usuario);
      this.usuarioService.atualizaUsuario(usuario)
        .subscribe(
          () => { alert('Salvo com sucesso.'); this.router.navigateByUrl('/usuario/listar'); },
          (error) => { alert('Falha ao atualizar usuario. ' + error.error); });
    }

}
