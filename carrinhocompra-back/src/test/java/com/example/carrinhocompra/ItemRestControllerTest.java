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

import com.example.carrinhocompra.item.Item;
import com.example.carrinhocompra.item.ItemRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrinhocompraApplication.class)
@WebAppConfiguration
public class ItemRestControllerTest extends BaseTestRestController {

	Item item;
	Item item2;
	Item itemInvalido;
	Item itemInvalido2;
	Item itemInvalido3;
	private List<Item> listaTipos;


	@MockBean
	ItemRepository itemRepository;

	@Before
	public void setup() throws Exception {

		mockMvc = webAppContextSetup(webApplicationContext).build();
		
		item = new Item("1", "teste", 1.0, null);
		item2 = new Item("1", "teste", 1.0, null);
		itemInvalido = new Item(null, "teste", 1.0, null);
		itemInvalido2 = new Item("1", "teste", 1.0, null);

		listaTipos = Arrays.asList(new Item[] { item, item2 });

		when(itemRepository.save(any(Item.class))).thenReturn(item);
		when(itemRepository.findById("1")).thenReturn(Optional.of(item));
		when(itemRepository.findById(null)).thenReturn(Optional.ofNullable(null));
		when(itemRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(listaTipos));
		when(itemRepository.findAll()).thenReturn(listaTipos);

		doNothing().when(itemRepository).deleteById(item.getId());
		
	}

	@Test
	public void criaItem() throws Exception {
		//Item Válido 
		String validItemJson = json(item);

		 MvcResult result = this.mockMvc.perform(post("/api/item").contentType(contentType).content(validItemJson))
				 .andExpect(status().is2xxSuccessful())
				 .andReturn();
		 
		assertThat(result.getResponse().getStatus()).isEqualTo(201);
		
		//Item Existente
		when(itemRepository.findByNome((any(String.class)))).thenReturn(listaTipos);
		String invalidItemJson = json(item);

		result = this.mockMvc.perform(post("/api/item/").contentType(contentType).content(invalidItemJson))
				.andExpect(status().is4xxClientError())
				.andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(400);
		
		//Item Invalido
		 invalidItemJson = json(new Item(null, "", null, null));

		 result = this.mockMvc.perform(post("/api/item/").contentType(contentType).content(invalidItemJson))
				.andExpect(status().is4xxClientError())
				.andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(400);
	}

	@Test
	public void excluiItem() throws Exception {
		//Existente
		MvcResult result = this.mockMvc.perform(delete("/api/item/" + item.getId())).andExpect(status().isOk()).andReturn();
		verify(itemRepository, times(1)).deleteById(item.getId());
		assertThat(result.getResponse().getStatus()).isEqualTo(200);		
		
	}

	@Test
	public void buscarLista() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/item/")).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);

	}
	
	@Test
	public void buscarPorId() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/item/" + item.getId())).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);

	}

}
