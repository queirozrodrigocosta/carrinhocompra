import { Item } from './item';
import { Usuario } from './usuario';

export interface Carrinho {
 id: string;
 quantidade: number;
 usuario: Usuario;
 item: Item;
}
