package com.ares.projetoterraviva.controller;

import com.ares.projetoterraviva.model.Usuario;
import com.ares.projetoterraviva.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioRepository repository;

    public AuthController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestBody Usuario dadosLogin) {
        Optional<Usuario> usuarioEncontrado = repository.findByEmail(dadosLogin.getEmail());
        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(dadosLogin.getSenha())) {
            return ResponseEntity.ok(Map.of("mensagem", "Login efetuado com sucesso!", "nome", usuarioEncontrado.get().getNome()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("erro", "E-mail ou senha incorretos."));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario novoUsuario) {
        if (repository.findByEmail(novoUsuario.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("erro", "Este e-mail já está em uso."));
        }

        Usuario usuarioSalvo = repository.save(novoUsuario);

        return ResponseEntity.ok(Map.of("mensagem", "Conta criada com sucesso!", "id", usuarioSalvo.getId()));
    }
}