package com.loja.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loja.dominio.produto.Produto;
import com.loja.dominio.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    public ProdutoServico(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public List<Produto> listaTodos(){
        return produtoRepositorio.findAll();
    }

    
    public Optional<Produto> findById(Long id) {
        return produtoRepositorio.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public void delete(Long id) {
        produtoRepositorio.deleteById(id);
    }
 
}
