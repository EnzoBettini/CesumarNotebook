package com.eb.atividadegerenciamento.services;

import com.eb.atividadegerenciamento.models.EstudanteModel;
import com.eb.atividadegerenciamento.respositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public EstudanteModel atualizarEstudante(Long id, EstudanteModel estudanteNovo) {
        Optional<EstudanteModel> estudanteOptional = estudanteRepository.findById(id);

        if (estudanteOptional.isPresent()) {
            EstudanteModel estudanteNoBanco = estudanteOptional.get();
            estudanteNoBanco.setNome(estudanteNovo.getNome());
            return estudanteRepository.save(estudanteNoBanco);

        } else {
            throw new RuntimeException("Usuário com esse id inexistente");
        }
    }
}
