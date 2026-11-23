package com.ares.projetoterraviva.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String produto;

    @Column(nullable = false)
    private Double quantidade;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;
}