package com.ares.projetoterraviva.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cultivos")
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false, length = 100)
    private String cultura;

    @Column(name = "data_plantio", nullable = false)
    private LocalDate dataPlantio;

    @Column(name = "previsao_colheita")
    private LocalDate previsaoColheita;

    @Column(name = "quantidade_mudas")
    private Integer quantidadeMudas;

    @Column(length = 50)
    private String status;
}