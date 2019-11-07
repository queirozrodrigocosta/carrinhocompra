import { Item } from './item';

export interface Usuario {
 id: string;
 nome: string;
 email: string;
 total: number;
 item: Array<Item>;
}
