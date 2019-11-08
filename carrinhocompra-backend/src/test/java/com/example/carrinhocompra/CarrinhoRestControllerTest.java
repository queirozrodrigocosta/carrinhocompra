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

import com.example.carrinhocompra.carrinho.Carrinho;
import com.example.carrinhocompra.carrinho.CarrinhoRepository;
import com.example.carrinhocompra.item.Item;
import com.example.carrinhocompra.usuario.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrinhocompraApplication.class)
@WebAppConfiguration
public class CarrinhoRestControllerTest extends BaseTestRestController {

	Item item; 
	Carrinho carrinho;
	Carrinho carrinho2;
	Carrinho carrinhoInvalido;
	Carrinho carrinhoInvalido2;
	Carrinho carrinhoInvalido3;
	private List<Carrinho> listaTipos;
	Optional<Carrinho> optcarrinho;


	@MockBean
	CarrinhoRepository carrinhoRepository;

	@Before
	public void setup() throws Exception {

		mockMvc = webAppContextSetup(webApplicationContext).build();
		
		item = new Item("1", "teste", 1.0, null);
		carrinho = new Carrinho("1", 1, null, item);
		carrinho2 = new Carrinho("1", 1, null, item);
		carrinhoInvalido = new Carrinho(null, 1, null, null);
		carrinhoInvalido2 = new Carrinho("1", 1, null, null);

		listaTipos = Arrays.asList(new Carrinho[] { carrinho, carrinho2 });

		when(carrinhoRepository.save(any(Carrinho.class))).thenReturn(carrinho);
		when(carrinhoRepository.findById("1")).thenReturn(Optional.of(carrinho));
		when(carrinhoRepository.findById(null)).thenReturn(Optional.ofNullable(null));
		when(carrinhoRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(listaTipos));
		when(carrinhoRepository.findAll()).thenReturn(listaTipos);

		doNothing().when(carrinhoRepository).deleteById(carrinho.getId());
		
	}

	@Test
	public void criaCarrinho() throws Exception {
		//Carrinho Válido 
		String validCarrinhoJson = json(carrinho);

		 MvcResult result = this.mockMvc.perform(post("/api/carrinho").contentType(contentType).content(validCarrinhoJson))
				 .andExpect(status().is2xxSuccessful())
				 .andReturn();
		 
		assertThat(result.getResponse().getStatus()).isEqualTo(201);
		
		//Carrinho Existente
		when(carrinhoRepository.findByUsuario((any(Usuario.class)))).thenReturn(optcarrinho);
		when(carrinhoRepository.findByUsuarioAndItem((any(Usuario.class)), (any(Item.class)))).thenReturn(optcarrinho);
		String invalidCarrinhoJson = json(carrinhoInvalido);

		result = this.mockMvc.perform(post("/api/carrinho/").contentType(contentType).content(invalidCarrinhoJson))
				.andExpect(status().is4xxClientError())
				.andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(400);
		
		//Carrinho Invalido
		 invalidCarrinhoJson = json(new Carrinho(null, 1, null, null));

		 result = this.mockMvc.perform(post("/api/carrinho/").contentType(contentType).content(invalidCarrinhoJson))
				.andExpect(status().is4xxClientError())
				.andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(400);
	}

	@Test
	public void excluiCarrinho() throws Exception {
		//Existente
		MvcResult result = this.mockMvc.perform(delete("/api/carrinho/" + carrinho.getId())).andExpect(status().isOk()).andReturn();
		verify(carrinhoRepository, times(1)).deleteById(carrinho.getId());
		assertThat(result.getResponse().getStatus()).isEqualTo(200);		
		
	}

	@Test
	public void buscarLista() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/carrinho/")).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);

	}
	
	@Test
	public void buscarPorId() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/carrinho/" + carrinho.getId())).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);

	}

}
