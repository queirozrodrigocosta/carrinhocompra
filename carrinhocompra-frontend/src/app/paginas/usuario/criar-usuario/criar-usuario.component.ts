import { Component, ViewChild } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/interfaces/usuario';

@Component({
  selector: 'app-criar-usuario',
  templateUrl: './criar-usuario.component.html',
  styleUrls: ['./criar-usuario.component.css']
})
export class CriarUsuarioComponent {

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  addUsuario(usuario: Usuario) {
    this.usuarioService.addUsuario(usuario)
      .subscribe(
        () => { alert('Salvo com sucesso.'); this.router.navigateByUrl('/usuario/listar'); },
        (error) => { alert('Falha ao adicionar usuario. ' + error.error);  });
  }

}
