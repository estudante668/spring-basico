package com.loja.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.dominio.produto.Produto;

//camada de percistencia com banco dados
@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
