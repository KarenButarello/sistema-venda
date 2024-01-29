package br.com.sistema.venda.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class NovaVenda {
    private BigDecimal valor;
    private Long idVendedor;
}
