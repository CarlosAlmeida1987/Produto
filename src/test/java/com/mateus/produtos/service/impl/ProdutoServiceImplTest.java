package com.mateus.produtos.service.impl;

import com.mateus.produtos.DAO.ProdutoDAO;
import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceImplTest {

    @Mock
    private ProdutoDAO produtoDAO;

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProdutos_DeveRetornarListaDeProdutos() {
        List<Produto> produtos = Arrays.asList(new Produto(1L, "Arroz", "Promocao", new BigDecimal("11.90"), 40), new Produto(2L, "Carnes", "Promocao", new BigDecimal("41.90"), 120));
        when(produtoDAO.findAll()).thenReturn(produtos);

        List<Produto> resultado = produtoService.getAllProdutos();

        assertEquals(2, resultado.size());
        verify(produtoDAO, times(1)).findAll();
    }

    @Test
    void getProdutoById_DeveRetornarProduto() {
        ProdutosDTO produtosDTO = new ProdutosDTO(1L, "Produto A", "Promocao", new BigDecimal("11.90"), 40);
        
        when(produtoDAO.findById(1L)).thenReturn(Optional.of(produtosDTO));

        Optional<ProdutosDTO> resultado = produtoService.getProdutoById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Produto A", resultado.get().getNome());
        verify(produtoDAO, times(1)).findById(1L);
    }

    @Test
    void saveProduto_DeveSalvarProduto() {
        Produto produto = new Produto(null, "Novo Produto", "Promocao", new BigDecimal("13.90"), 40);
        Produto produtoSalvo = new Produto(1L, "Novo Produto", "Promocao", new BigDecimal("13.90"), 10);
        when(produtoDAO.save(produto)).thenReturn(produtoSalvo);

        Produto resultado = produtoService.saveProduto(produto);

        assertNotNull(resultado.getId());
        assertEquals("Novo Produto", resultado.getNome());
        verify(produtoDAO, times(1)).save(produto);
    }

    @Test
    void deleteProduto_DeveDeletarProduto() {
        doNothing().when(produtoDAO).deleteById(1L);

        produtoService.deleteProduto(1L);

        verify(produtoDAO, times(1)).deleteById(1L);
    }
}
