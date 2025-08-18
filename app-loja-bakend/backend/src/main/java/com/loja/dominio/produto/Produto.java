package com.loja.dominio.produto;

import java.math.BigDecimal;


import com.loja.dominio.categoria.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data                   // Lombok cria os acessos da classe
@NoArgsConstructor      // Construtor vazio para instanciamentos
@AllArgsConstructor     // Construtor com entras
@Builder                // Permite usar o padrão Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull    
    private BigDecimal preco;

    @ManyToOne
    private Categoria categoria;

    private String description;

    private boolean active;

}

