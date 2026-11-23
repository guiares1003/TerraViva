package com.ares.projetoterraviva.controller;

import com.ares.projetoterraviva.model.Estoque;
import com.ares.projetoterraviva.repository.CultivoRepository;
import com.ares.projetoterraviva.repository.EstoqueRepository;
import com.ares.projetoterraviva.repository.VendasRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final CultivoRepository cultivoRepository;
    private final EstoqueRepository estoqueRepository;
    private final VendasRepository vendasRepository;

    public DashboardController(CultivoRepository cultivoRepository, EstoqueRepository estoqueRepository, VendasRepository vendasRepository) {
        this.cultivoRepository = cultivoRepository;
        this.estoqueRepository = estoqueRepository;
        this.vendasRepository = vendasRepository;
    }

    @GetMapping("/resumo")
    public Map<String, Object> obterResumo() {
        long totalCultivos = cultivoRepository.count();
        long totalEstoqueItens = estoqueRepository.count();
        long totalVendas = vendasRepository.count();
        long estoqueBaixo = estoqueRepository.findAll().stream()
                .filter(item -> item.getQuantidade() <= item.getNivelMinimoAlerta())
                .count();

        return Map.of(
                "cultivosAtivos", totalCultivos,
                "estoqueTotal", totalEstoqueItens,
                "estoqueBaixo", estoqueBaixo,
                "vendasMes", totalVendas
        );
    }
}