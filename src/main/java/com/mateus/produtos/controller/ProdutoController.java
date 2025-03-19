package com.mateus.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;
import com.mateus.produtos.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
private final ProdutoService service;
    
    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Produto> getAllProducts() { 
    	return service.getAllProdutos(); 
    }
    
    @GetMapping("/{id}")
    public ProdutosDTO getProdutoById(@PathVariable Long id) {
        return service.getProdutoById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    
    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
    	return service.saveProduto(produto); 
    }
    
    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
    	if (!service.getProdutoById(id).isPresent()) {
            throw new RuntimeException("Produto não encontrado");
        }
    	produto.setId(id);
        return service.saveProduto(produto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) { 
    	if (!service.getProdutoById(id).isPresent()) {
            throw new RuntimeException("Produto não encontrado");
        }
    	service.deleteProduto(id); 
    }

}
