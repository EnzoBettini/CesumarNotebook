package com.eb.swagger.controllers;

import com.eb.swagger.models.EstudanteModel;
import com.eb.swagger.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> getEstudante() {
        List<EstudanteModel> encontrados = estudanteService.encontrarTodos();
        return ResponseEntity.ok(encontrados);
    }

    @PostMapping
    public ResponseEntity<EstudanteModel> addEstudante(@RequestBody EstudanteModel estudanteModel) {
        EstudanteModel estudanteNovo = estudanteService.adicionarEstudante(estudanteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudanteNovo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteModel> acharPorId(@PathVariable Long id) {
        return estudanteService.encontrarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEstudante(@PathVariable Long id) {
        // 1. Tenta buscar o estudante para ver se ele existe
        return estudanteService.encontrarPorId(id)
                .map(estudante -> {
                    // 2. Se achou, chama o seu service para remover
                    estudanteService.removerEstudante(id);
                    // 3. Retorna 204 No Content (padrão para delete com sucesso)
                    return ResponseEntity.noContent().build();
                })
                // 4. Se o optional veio vazio, retorna 404 Not Found
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEstudante2(@PathVariable Long id) {
        // 1. Primeiro, verificamos se o estudante existe no banco
        Optional<EstudanteModel> estudanteOpcional = estudanteService.encontrarPorId(id);

        // 2. Visualmente, decidimos o caminho:
        if (estudanteOpcional.isPresent()) {
            // CAMINHO DO SUCESSO:
            estudanteService.removerEstudante(id); // Chama o service para apagar
            return ResponseEntity.noContent().build(); // Retorna 204 (Deu certo e está vazio)
        } else {
            // CAMINHO DO ERRO:
            return ResponseEntity.notFound().build(); // Retorna 404 (Não encontrei esse ID)
        }
    }

    @PostMapping
    public ResponseEntity<EstudanteModel> addEstudante2(@RequestBody EstudanteModel estudanteModel) {
        // 1. O Service salva o estudante e o banco gera o ID
        EstudanteModel novoEstudante = estudanteService.adicionarEstudante(estudanteModel);

        // 2. Criamos a URI (o endereço) para acessar esse novo estudante
        // Isso pega o caminho atual (/estudantes) e adiciona o /{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoEstudante.getId())
                .toUri();

        // 3. Retornamos o status 201 (Created) passando a URI no cabeçalho e o objeto no corpo
        return ResponseEntity.created(uri).body(novoEstudante);
    }
}
