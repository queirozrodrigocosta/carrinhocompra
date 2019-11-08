import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Usuario } from '../../interfaces/usuario';

@Component({
  selector: 'app-form-usuario',
  templateUrl: './form-usuario.component.html',
  styleUrls: ['./form-usuario.component.css']
})
export class FormUsuarioComponent {
  @Input() usuario: Usuario = <Usuario>{};
  @Output() outputUsuario: EventEmitter<Usuario> = new EventEmitter();

  onSubmit() {
    this.outputUsuario.emit(this.usuario);
  }

}
