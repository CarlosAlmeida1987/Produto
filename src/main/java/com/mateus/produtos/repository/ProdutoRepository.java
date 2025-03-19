package com.mateus.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
