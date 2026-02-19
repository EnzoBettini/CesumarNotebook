package com.eb.school.controllers;

import com.eb.school.models.AlunoModel;
import com.eb.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoModel> findAll() {
        return alunoService.findAll();
    }

    @PostMapping
    public AlunoModel criar(@RequestBody AlunoModel alunoModel) {
        return alunoService.criar(alunoModel);
    }
}
