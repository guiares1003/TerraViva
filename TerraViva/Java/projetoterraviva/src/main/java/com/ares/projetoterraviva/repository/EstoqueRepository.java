package com.ares.projetoterraviva.repository;

import com.ares.projetoterraviva.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}