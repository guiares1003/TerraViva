package com.ares.projetoterraviva.controller;

import com.ares.projetoterraviva.model.Cultivo;
import com.ares.projetoterraviva.repository.CultivoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultivos")
@CrossOrigin(origins = "*")
public class CultivoController {

    private final CultivoRepository repository;

    public CultivoController(CultivoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cultivo> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Cultivo criar(@RequestBody Cultivo cultivo) {
        if(cultivo.getStatus() == null || cultivo.getStatus().isEmpty()) {
            cultivo.setStatus("Em desenvolvimento");
        }
        return repository.save(cultivo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}