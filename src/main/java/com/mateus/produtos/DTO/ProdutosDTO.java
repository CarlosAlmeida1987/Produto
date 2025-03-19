package com.mateus.produtos.DTO;

import java.math.BigDecimal;

import com.mateus.produtos.model.Produto;

public class ProdutosDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer estoque;
	
	
	public ProdutosDTO(Long id, String nome, String descricao, BigDecimal preco, Integer estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public ProdutosDTO(Produto produto) {

		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.estoque = produto.getEstoque();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
}
