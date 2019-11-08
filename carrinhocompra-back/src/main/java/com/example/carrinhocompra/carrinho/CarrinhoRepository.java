package com.example.carrinhocompra.carrinho;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.carrinhocompra.item.Item;
import com.example.carrinhocompra.usuario.Usuario;


public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {

	
	Optional<Carrinho> findByUsuario(Usuario usuario);
	
	Optional<Carrinho> findByUsuarioAndItem(Usuario usuario, Item item);


	
}
