package com.eb.school.services;

import com.eb.school.models.AlunoModel;
import com.eb.school.models.ProfessorModel;
import com.eb.school.repositories.ProfessorRepository;
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
