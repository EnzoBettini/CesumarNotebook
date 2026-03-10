package com.eb.aula3.services;

import com.eb.aula3.models.AlunoModel;
import com.eb.aula3.repositories.AlunoRepository;
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

    public void deletar(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Aluno com id inexistente");
        }
    }
}
