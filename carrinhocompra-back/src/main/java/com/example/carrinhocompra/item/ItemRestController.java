package com.example.carrinhocompra.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/item")		
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	@PostMapping
	public ResponseEntity<Item> createUpdateItem(@RequestBody Item item) throws Exception {
		try {
			item = itemService.createUpdateItem(item);
			return new ResponseEntity<>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getitemPorId(@PathVariable String id) throws Exception {
		try {
			return ResponseEntity.ok((itemService.getItemPorId(id)));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping
	@ApiOperation(value = "lista", response = Item.class)
	public ResponseEntity<List<Item>> lista() throws Exception {
		try {
			return ResponseEntity.ok().body(itemService.getAllItems());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteitem(@PathVariable String id) throws Exception {
		try {
			itemService.deleteItem(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
