package com.ares.projetoterraviva.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_item", nullable = false, length = 100)
    private String nomeItem;

    @Column(nullable = false)
    private Double quantidade;

    @Column(name = "unidade_medida", length = 20)
    private String unidadeMedida; // Ex: kg, litros, sacas

    @Column(name = "nivel_minimo_alerta")
    private Double nivelMinimoAlerta;
}