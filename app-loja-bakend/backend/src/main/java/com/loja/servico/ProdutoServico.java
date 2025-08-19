package com.loja.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loja.dominio.produto.Produto;
import com.loja.dominio.repositorio.ProdutoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    public ProdutoServico(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public List<Produto> listaTodos(){
        return produtoRepositorio.findAll();
    }

    
    public Optional<Produto> listarPorId(Long id) {
        return produtoRepositorio.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public void deletar(Long id) {
    if (!produtoRepositorio.existsById(id)) {
        throw new EntityNotFoundException("Produto não encontrado com ID: " + id);
    }
    produtoRepositorio.deleteById(id);
}
}
