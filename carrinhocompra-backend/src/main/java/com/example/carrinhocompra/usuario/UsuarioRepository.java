package com.example.carrinhocompra.usuario;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	List<Usuario> findByNome(String nome);

	
}
