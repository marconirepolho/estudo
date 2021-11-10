package com.estudo.controller.filtro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoFilter {

    private Integer produtoId;
    private String nome;
    private BigDecimal valor;
    private Integer categoriaId;
    private String categoriaNome;
}
