package com.example.carrinhocompra.item;

import org.springframework.data.annotation.Id;

import com.example.carrinhocompra.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@AllArgsConstructor @ToString @EqualsAndHashCode
public class Item {

	@Id
	private String id;

	private String nome;

	private Double valor;
	
    private Usuario usuario;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
