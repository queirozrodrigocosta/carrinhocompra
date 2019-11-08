import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../interfaces/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  getListaUsuarios(): Observable<Usuario[]> {
    const url = `${environment.apiUrl}/usuario`;
    return this.http.get<Usuario[]>(url);
  }

  getUsuario(id: string): Observable<Usuario> {
    const url = `${environment.apiUrl}/usuario/${id}`;
    return this.http.get<Usuario>(url);
  }

  addUsuario(usuario: Usuario): Observable<Usuario> {
    const url = `${environment.apiUrl}/usuario/`;
    return this.http.post<Usuario>(url, usuario);
  }

  atualizaUsuario(usuario: Usuario): Observable<Usuario> {
    const url = `${environment.apiUrl}/usuario/`;
    return this.http.post<Usuario>(url, usuario);
  }

  deletaUsuario(id: string): Observable<Usuario> {
    const url = `${environment.apiUrl}/usuario/${id}`;
    return this.http.delete<Usuario>(url);
  }

}
