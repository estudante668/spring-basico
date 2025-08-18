package com.loja.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.dominio.categoria.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
