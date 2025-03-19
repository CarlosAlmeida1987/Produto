package com.mateus.produtos.service;

import java.util.List;
import java.util.Optional;

import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;

public interface ProdutoService {

	List<Produto> getAllProdutos();

	Optional<ProdutosDTO> getProdutoById(Long id);

	Produto saveProduto(Produto produto);

	void deleteProduto(Long id);

	

}
