package com.example.carrinhocompra.carrinho;

import org.springframework.data.annotation.Id;

import com.example.carrinhocompra.item.Item;
import com.example.carrinhocompra.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


public class CarrinhoLista {

	private String id;

	private Integer quantidade;
	
	private Usuario usuario;
	
	private Item item;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
