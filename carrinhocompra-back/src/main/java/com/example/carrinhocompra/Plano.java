package com.example.carrinhocompra;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Plano {

	@Id
	private String id;
	
	private String nome;
	
	private String descrição;
	
	private String vantagens;
	
	private BigDecimal valor;
	
	private TipoPlano tipo;

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

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getVantagens() {
		return vantagens;
	}

	public void setVantagens(String vantagens) {
		this.vantagens = vantagens;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoPlano getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlano tipo) {
		this.tipo = tipo;
	}	
	
	
}

enum TipoPlano{
	PRE,
	POS,
	CONTROLE;
}
