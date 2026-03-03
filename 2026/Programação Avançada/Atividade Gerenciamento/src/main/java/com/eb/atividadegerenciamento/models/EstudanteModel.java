package com.eb.atividadegerenciamento.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudanteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula")
    private Long id;

    private String nome;

    @Column(name = "contato")
    private String email;

    private Integer idade;

    public void setId(Long o) {
    }
}
