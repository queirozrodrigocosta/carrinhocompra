import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Carrinho } from '../interfaces/carrinho';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {

  constructor(private http: HttpClient) { }

  getListaCarrinhos(): Observable<Carrinho[]> {
    const url = `${environment.apiUrl}/carrinho`;
    return this.http.get<Carrinho[]>(url);
  }

  getCarrinho(id: string): Observable<Carrinho> {
    const url = `${environment.apiUrl}/carrinho/${id}`;
    return this.http.get<Carrinho>(url);
  }

  addCarrinho(carrinho: Carrinho): Observable<Carrinho> {
    const url = `${environment.apiUrl}/carrinho/`;
    return this.http.post<Carrinho>(url, carrinho);
  }

  atualizaCarrinho(carrinho: Carrinho): Observable<Carrinho> {
    const url = `${environment.apiUrl}/carrinho/`;
    return this.http.post<Carrinho>(url, carrinho);
  }

  deletaCarrinho(id: string): Observable<Carrinho> {
    const url = `${environment.apiUrl}/carrinho/${id}`;
    return this.http.delete<Carrinho>(url);
  }

}
