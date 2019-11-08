package com.example.carrinhocompra;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;

import com.example.carrinhocompra.usuario.Usuario;
import com.example.carrinhocompra.usuario.UsuarioRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrinhocompraApplication.class)
@WebAppConfiguration
public class UsuarioRestControllerTest extends BaseTestRestController {

	Usuario usuario;
	Usuario usuario2;
	Usuario usuarioInvalido;
	Usuario usuarioInvalido2;
	Usuario usuarioInvalido3;
	private List<Usuario> listaTipos;


	@MockBean
	UsuarioRepository usuarioRepository;

	@Before
	public void setup() throws Exception {

		mockMvc = webAppContextSetup(webApplicationContext).build();
		
		usuario = new Usuario("1", "teste", "teste", 1.0);
		usuario2 = new Usuario("1", "teste", "teste", 1.0);
		usuarioInvalido = new Usuario(null, "teste", "teste", 1.0);
		usuarioInvalido2 = new Usuario("1", "teste", "teste", 1.0);

		listaTipos = Arrays.asList(new Usuario[] { usuario, usuario2 });

		when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
		when(usuarioRepository.findById("1")).thenReturn(Optional.of(usuario));
		when(usuarioRepository.findById(null)).thenReturn(Optional.ofNullable(null));
		when(usuarioRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(listaTipos));
		when(usuarioRepository.findAll()).thenReturn(listaTipos);

		doNothing().when(usuarioRepository).deleteById(usuario.getId());
		
	}

	@Test
	public void criaUsuario() throws Exception {
		//Usuario Válido 
		String validUsuarioJson = json(usuario);

		 MvcResult result = this.mockMvc.perform(post("/api/usuario").contentType(contentType).content(validUsuarioJson))
				 .andExpect(status().is2xxSuccessful())
				 .andReturn();
		 
		assertThat(result.getResponse().getStatus()).isEqualTo(201);
		
		//Usuario Existente
		when(usuarioRepository.findByNome((any(String.class)))).thenReturn(listaTipos);
		String invalidUsuarioJson = json(usuario);

		result = this.mockMvc.perform(post("/api/usuario/").contentType(contentType).content(invalidUsuarioJson))
				.andExpect(status().is4xxClientError())
				.andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(400);
		
		//Usuario Invalido
		 invalidUsuarioJson = json(new Usuario(null, "", "", null));

		 result = this.mockMvc.perform(post("/api/usuario/").contentType(contentType).content(invalidUsuarioJson))
				.andExpect(status().is4xxClientError())
				.andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(400);
	}

	@Test
	public void excluiUsuario() throws Exception {
		//Existente
		MvcResult result = this.mockMvc.perform(delete("/api/usuario/" + usuario.getId())).andExpect(status().isOk()).andReturn();
		verify(usuarioRepository, times(1)).deleteById(usuario.getId());
		assertThat(result.getResponse().getStatus()).isEqualTo(200);		
		
	}

	@Test
	public void buscarLista() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/usuario/")).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);

	}
	
	@Test
	public void buscarPorId() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/usuario/" + usuario.getId())).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);

	}

}
