package com.loja.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.dominio.produto.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
