import { Usuario } from './usuario';

export interface Item {
 id: string;
 nome: string;
 valor: number;
 usuario: Usuario;
}
