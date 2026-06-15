package com.spring.security.models;


import jakarta.persistence.*;
import lombok.Data;

/*
 * Classe que representa a entidade Pessoa no banco de dados.
 *
 * A anotação @Entity informa ao JPA/Hibernate
 * que essa classe será transformada em uma tabela.
 */

@Entity

/*
 * Define o nome da tabela no banco de dados.
 *
 * Nesse caso:
 * TBL_PESSOAS
 */
@Table(name = "TBL_PESSOAS")

/*
 * @Data é uma anotação do Lombok.
 *
 * Ela gera automaticamente:
 * - getters
 * - setters
 * - toString()
 * - equals()
 * - hashCode()
 */
@Data
public class PessoaModel {

    /*
     * Define o atributo como chave primária da tabela.
     */
    @Id

    /*
     * Define que o ID será gerado automaticamente
     * pelo banco de dados.
     *
     * IDENTITY:
     * normalmente usado com AUTO_INCREMENT.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Campo que armazena o nome da pessoa.
     */
    private String nome;

}