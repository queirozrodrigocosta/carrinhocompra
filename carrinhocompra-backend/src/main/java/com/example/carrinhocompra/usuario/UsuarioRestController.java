package com.example.carrinhocompra.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuario")		
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> createUpdateUsuario(@RequestBody Usuario usuario)  {
		try {
			usuario = usuarioService.createUpdateUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getusuarioPorId(@PathVariable String id) throws Exception {
		try {
		return ResponseEntity.ok((usuarioService.getUsuarioPorId(id)));
	} catch (Exception e) {
		e.printStackTrace();
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

	}		
	}

	@GetMapping
	@ApiOperation(value = "lista", response = Usuario.class)
	public ResponseEntity<List<Usuario>> lista() throws Exception {
		try {
		return ResponseEntity.ok().body(usuarioService.getAllUsuarios());
		} catch (Exception e) {
			e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteusuario(@PathVariable String id) throws Exception {
		try {
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
