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
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data                   // Lombok cria os acessos da classe
@NoArgsConstructor      // Construtor vazio para instanciamentos           
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

    public Produto(Long id, @NotBlank String nome) {
        this.id = id;
        this.nome = nome;
    }

}

