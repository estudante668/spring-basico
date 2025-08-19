package com.loja.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDTO {
      
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
}

