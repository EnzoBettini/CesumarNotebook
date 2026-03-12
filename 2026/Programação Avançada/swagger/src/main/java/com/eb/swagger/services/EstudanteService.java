package com.eb.swagger.services;

import com.eb.swagger.models.EstudanteModel;
import com.eb.swagger.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> encontrarTodos() {
        return estudanteRepository.findAll();
    }

    public Optional<EstudanteModel> encontrarPorId(Long id) {
        return estudanteRepository.findById(id);
    }

    public EstudanteModel adicionarEstudante(EstudanteModel estudante) {
        return estudanteRepository.save(estudante);
    }

    public EstudanteModel atualizarEstudantePorId(EstudanteModel estudante, Long id) {
       Optional<EstudanteModel> estudanteAntigo = estudanteRepository.findById(id);
       if (estudanteAntigo.isPresent()) {
           EstudanteModel estudanteAtualizar = estudanteAntigo.get();
           estudanteAtualizar.setNome(estudante.getNome());
           estudanteAtualizar.setDocumento(estudante.getDocumento());
           return estudanteRepository.save(estudanteAtualizar);
       } else {
           throw new RuntimeException("Estudante nao existente com esse id");
       }
    }

    public void removerEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }
}
