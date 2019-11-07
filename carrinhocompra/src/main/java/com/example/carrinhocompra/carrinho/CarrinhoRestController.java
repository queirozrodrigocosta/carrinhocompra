package com.example.carrinhocompra.carrinho;

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
@RequestMapping("/api/carrinho")		
public class CarrinhoRestController {

	@Autowired
	private CarrinhoService carrinhoService;

	@PostMapping
	public ResponseEntity<Carrinho> createUpdateCarrinho(@RequestBody Carrinho carrinho) throws Exception {
		try {
			carrinho = carrinhoService.createUpdateCarrinho(carrinho);
			return new ResponseEntity<>(carrinho, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> getcarrinhoPorId(@PathVariable String id) throws Exception {
		try {
			return ResponseEntity.ok((carrinhoService.getCarrinhoPorId(id)));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping
	@ApiOperation(value = "lista", response = Carrinho.class)
	public ResponseEntity<List<Carrinho>> lista() throws Exception {
		try {
			return ResponseEntity.ok().body(carrinhoService.getAllCarrinhos());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletecarrinho(@PathVariable String id) throws Exception {
		try {
			carrinhoService.deleteCarrinho(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
