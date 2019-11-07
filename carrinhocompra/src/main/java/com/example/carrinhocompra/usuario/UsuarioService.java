package com.example.carrinhocompra.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {


	@Autowired
	private UsuarioRepository usuarioRepository;


	public Usuario createUpdateUsuario(Usuario usuario) throws Exception {
		try {
			if (usuario.getId() == null && !usuarioRepository.findByNome(usuario.getNome()).isEmpty()){
				throw new Exception("Cada usuário deve ser único");
			}

			return usuarioRepository.save(usuario);	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Usuario> getAllUsuarios() throws Exception {
		try {
			return usuarioRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void deleteUsuario(String id) throws Exception {
		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Usuario getUsuarioPorId(String id) throws Exception {
		try {
			Optional<Usuario> t = usuarioRepository.findById(id);
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
