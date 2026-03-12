package com.eb.swagger.repositories;

import com.eb.swagger.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
}
