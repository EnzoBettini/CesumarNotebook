package com.eb.atividadegerenciamento.services;

import com.eb.atividadegerenciamento.models.EstudanteModel;
import com.eb.atividadegerenciamento.respositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> acharTodos() {
        return estudanteRepository.findAll();
    }

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel) {
        return estudanteRepository.save(estudanteModel);
    }
}
