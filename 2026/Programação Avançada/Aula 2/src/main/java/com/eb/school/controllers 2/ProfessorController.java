package com.eb.school.controllers;

import com.eb.school.models.ProfessorModel;
import com.eb.school.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorModel> findAll() {
        return professorService.findAll();
    }

    @PostMapping
    public ProfessorModel criar(@RequestBody ProfessorModel professorModel) {
        return professorService.criar(professorModel);
    }
}
