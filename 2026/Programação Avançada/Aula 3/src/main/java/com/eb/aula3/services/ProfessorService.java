package com.eb.aula3.services;

import com.eb.aula3.models.AlunoModel;
import com.eb.aula3.models.ProfessorModel;
import com.eb.aula3.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorModel> findAll() {
        return professorRepository.findAll();
    }

    public ProfessorModel criar(ProfessorModel professorModel) {
        return professorRepository.save(professorModel);
    }
}
