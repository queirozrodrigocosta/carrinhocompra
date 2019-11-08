package com.example.carrinhocompra.item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;



@Service
public class ItemService {


	@Autowired
	private ItemRepository itemRepository;


	public Item createUpdateItem(Item item) throws Exception {
		try {
			if (item.getId() == null && !itemRepository.findByNome(item.getNome()).isEmpty()){
				throw new Exception("Cada usuário deve ser único");
			}

			return itemRepository.save(item);	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Item> getAllItems() throws Exception {
		try {
			return itemRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void deleteItem(String id) throws Exception {
		try {
			itemRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Item getItemPorId(String id) throws Exception {
		try {
			Optional<Item> t = itemRepository.findById(id);
			if (t.isPresent()) {
				return t.get();
			}
			else 
				throw new Exception("não encontrado");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
