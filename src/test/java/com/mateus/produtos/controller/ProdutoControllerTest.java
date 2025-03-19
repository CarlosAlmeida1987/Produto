package com.mateus.produtos.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mateus.produtos.DTO.ProdutosDTO;
import com.mateus.produtos.model.Produto;
import com.mateus.produtos.service.ProdutoService;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

	@MockBean
    private ProdutoService produtoService;

    private Produto produto;
    
    private ProdutosDTO produtosDTO;
    
    @BeforeEach
    void setUp() {
        produto = new Produto("Leite Ninho", "Promocao", new BigDecimal("36.90"), 60);
        produtosDTO = new ProdutosDTO(1L, "Leite Ninho", "Promocao", new BigDecimal("36.90"), 60);
    }

    @Test
    void getAllProdutosLista() throws Exception {
        when(produtoService.getAllProdutos()).thenReturn(Arrays.asList(produto));

        mockMvc.perform(get("/api/produto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].nome").value("Leite Ninho"));
    }

    @Test
    void getProdutoByIdRetornar() throws Exception {
        when(produtoService.getProdutoById(1L)).thenReturn(Optional.of(produtosDTO));

        mockMvc.perform(get("/api/produto/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Leite Ninho"));
    }
    
    @Test
    void createProduto() throws Exception {
        when(produtoService.saveProduto(any())).thenReturn(produto);

        mockMvc.perform(post("/api/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Leite Ninho"));
    }
        
    @Test
    void deleteProdutoRemover() throws Exception {
        doNothing().when(produtoService).deleteProduto(1L);

        mockMvc.perform(delete("/api/produto/1"))
                .andExpect(status().isOk());

        verify(produtoService, times(1)).deleteProduto(1L);
    }
}

