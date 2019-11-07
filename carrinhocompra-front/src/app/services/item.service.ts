import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../interfaces/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }

  getListaItems(): Observable<Item[]> {
    const url = `${environment.apiUrl}/item`;
    return this.http.get<Item[]>(url);
  }

  getItem(id: string): Observable<Item> {
    const url = `${environment.apiUrl}/item/${id}`;
    return this.http.get<Item>(url);
  }

  addItem(item: Item): Observable<Item> {
    const url = `${environment.apiUrl}/item/`;
    return this.http.post<Item>(url, item);
  }

  atualizaItem(item: Item): Observable<Item> {
    const url = `${environment.apiUrl}/item/`;
    return this.http.post<Item>(url, item);
  }

  deletaItem(id: string): Observable<Item> {
    const url = `${environment.apiUrl}/item/${id}`;
    return this.http.delete<Item>(url);
  }

}
