package com.loja.dominio.categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                   // Gera getters, setters, toString, equals, hashCode
@NoArgsConstructor      // Construtor vazio
@AllArgsConstructor     // Construtor com todos os atributos
@Builder                // Padrão Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}

