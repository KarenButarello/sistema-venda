package br.com.sistema.venda.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VendasVendedor {
    private String nome;
    private Integer totalVendas;
    private BigDecimal mediaVenda;
}
