package com.example.carrinhocompra.item;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ItemRepository extends MongoRepository<Item, String> {

	List<Item> findByNome(String nome);

	
}
