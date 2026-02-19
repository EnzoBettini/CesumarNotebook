package com.eb.school.services;

import com.eb.school.models.AlunoModel;
import com.eb.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoModel> findAll() {
        return alunoRepository.findAll();
    }

    public AlunoModel criar(AlunoModel alunoModel) {
        alunoModel.setId(null);
        return alunoRepository.save(alunoModel);
    }
}
