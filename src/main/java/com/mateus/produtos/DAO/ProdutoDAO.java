package com.mateus.produtos.DAO;

import java.util.List;
import java.util.Optional;

import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;

public interface ProdutoDAO {
	
	List<Produto> findAll();
    Optional<ProdutosDTO> findById(Long id);
    Produto save(Produto produto);
    void deleteById(Long id);


}
