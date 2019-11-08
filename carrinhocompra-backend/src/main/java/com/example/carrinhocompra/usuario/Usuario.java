package com.example.carrinhocompra.usuario;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.carrinhocompra.item.Item;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@AllArgsConstructor @ToString @EqualsAndHashCode
public class Usuario {

	@Id
	private String id;

	private String nome;

	private String email;
	
	private Double total;

//	private List<Item> item;	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario(String id, String nome, String email, Double total) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.total = total;
	}

	public Usuario() {
		super();
	}

	
	
//	public List<Item> getItens() {
//		return item;
//	}
//
//	public void setItens(List<Item> item) {
//		this.item = item;
//	}
	
	
}
