package com.mateus.produtos.DAO;

import com.mateus.produtos.DAO.impl.ProdutoDAOImpl;
import com.mateus.produtos.repository.ProdutoRepository;

public class ProdutoDAOFactory {
	public static ProdutoDAO createProdutoDAO(ProdutoRepository repository) {
        return new ProdutoDAOImpl(repository);
    }

}
