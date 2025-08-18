package com.loja.dominio.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.loja.dominio.categoria.Categoria;

//camada de percistencia com banco dados
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
