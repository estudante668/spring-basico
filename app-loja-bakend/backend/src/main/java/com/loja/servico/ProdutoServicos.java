package com.loja.servico;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loja.execption.ProdutoNotFoundException;
import com.loja.produto.Produto;
import com.loja.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServicos {
       
    private final ProdutoRepositorio produtoRepositorio; 
    
    public ProdutoServicos(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

     public List<Produto> findAll() {
        return produtoRepositorio.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepositorio.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public Produto update(Long id, Produto produtoAtualizado) {
        return produtoRepositorio.findById(id)
            .map(produtoExistente -> {
                produtoExistente.setNome(produtoAtualizado.getNome());
                produtoExistente.setPreco(produtoAtualizado.getPreco());
                return produtoRepositorio.save(produtoExistente);
            })
            .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

     public void deleteById(Long id) {
        if (!produtoRepositorio.existsById(id)) {
            throw new ProdutoNotFoundException(id); // Lança a exceção aqui
        }
        produtoRepositorio.deleteById(id);
    }
}
