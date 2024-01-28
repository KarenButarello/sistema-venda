package br.com.sistema.venda.model;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "vendedores")
@Entity
@Data
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nome", nullable = false)
    private String nome;
}
