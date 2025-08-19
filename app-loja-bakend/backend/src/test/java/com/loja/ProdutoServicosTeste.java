package com.loja;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.loja.dominio.produto.Produto;
import com.loja.dominio.repositorio.ProdutoRepositorio;
import com.loja.servico.ProdutoServico;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoServicosTeste {

    @Mock
    private ProdutoRepositorio produtoRepositorio;

    @InjectMocks
    private ProdutoServico produtoServico;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarModeloPorId() {
        Produto produto = new Produto(1L, "ola");
        when(produtoRepositorio.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> resultado = produtoServico.listarPorId(1l);

        assertTrue(resultado.isPresent());
        assertEquals("ola", resultado.get().getNome());
    }
}


