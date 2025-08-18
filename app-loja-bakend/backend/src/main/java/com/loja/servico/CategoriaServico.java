package com.loja.servico;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loja.dominio.categoria.Categoria;
import com.loja.dominio.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

    private final CategoriaRepositorio categoriaRepositorio;

    public CategoriaServico(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }
    
    public List<Categoria> buscarCategorias(){
        return this.categoriaRepositorio.findAll();
    }

    
    public Optional<Categoria> findById(Long id) {
        return this.categoriaRepositorio.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return this.categoriaRepositorio.save(categoria);
    }

    public void delete(Long id) {
        categoriaRepositorio.deleteById(id);
    }
}
