package com.eb.atividadegerenciamento.controllers;

import com.eb.atividadegerenciamento.models.EstudanteModel;
import com.eb.atividadegerenciamento.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public List<EstudanteModel> getEstudantes() {
        return estudanteService.acharTodos();
    }

    @PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel) {
        return estudanteService.criarEstudante(estudanteModel);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizarEstudante(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel) {
        return estudanteService.atualizarEstudante(id, estudanteModel);
    }
}
