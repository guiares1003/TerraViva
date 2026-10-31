package com.ares.projetoterraviva.repository;

import com.ares.projetoterraviva.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Venda, Long> {
}