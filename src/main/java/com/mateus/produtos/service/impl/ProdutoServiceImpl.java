package com.mateus.produtos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.produtos.DAO.ProdutoDAO;
import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;
import com.mateus.produtos.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoDAO produtoDAO;
    
    @Autowired
    public ProdutoServiceImpl(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    
	@Override
	public List<Produto> getAllProdutos() {
		// TODO Auto-generated method stub
		return produtoDAO.findAll();
	}

	@Override
	public Optional<ProdutosDTO> getProdutoById(Long id) {
		return produtoDAO.findById(id);
	}

	@Override
	public Produto saveProduto(Produto produto) {
		// TODO Auto-generated method stub
		return produtoDAO.save(produto);
	}

	@Override
	public void deleteProduto(Long id) {
		// TODO Auto-generated method stub
		produtoDAO.deleteById(id);
	}
}
