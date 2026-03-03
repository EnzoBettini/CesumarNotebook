package com.eb.atividadegerenciamento.respositories;

import com.eb.atividadegerenciamento.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
}
