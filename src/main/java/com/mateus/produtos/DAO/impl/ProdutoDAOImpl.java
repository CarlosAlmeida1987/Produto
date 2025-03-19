package com.mateus.produtos.DAO.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mateus.produtos.DAO.ProdutoDAO;
import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;
import com.mateus.produtos.repository.ProdutoRepository;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO {
	
	private final ProdutoRepository repository;
    
    @Autowired
    public ProdutoDAOImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ProdutosDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).map(produto -> new ProdutosDTO(produto));
	}

	@Override
	public Produto save(Produto produto) {
		// TODO Auto-generated method stub
		return repository.save(produto);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
