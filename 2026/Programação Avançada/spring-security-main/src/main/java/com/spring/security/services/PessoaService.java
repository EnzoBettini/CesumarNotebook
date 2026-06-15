package com.spring.security.services;

import com.spring.security.models.PessoaModel;
import com.spring.security.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Classe responsável pelas regras de negócio
 * relacionadas à entidade Pessoa.
 *
 * A anotação @Service indica que essa classe
 * pertence à camada de serviço da aplicação.
 */

@Service
public class PessoaService {

    /*
     * Injeta automaticamente o repository da Pessoa.
     *
     * O repository será utilizado para acessar
     * o banco de dados.
     */
    @Autowired
    PessoaRepository pessoaRepository;

    /*
     * Método responsável por listar todas as pessoas
     * cadastradas no banco.
     *
     * findAll() já é fornecido pelo JpaRepository.
     *
     * Retorna:
     * Uma lista de pessoas.
     */

    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    /*
     * Método responsável por cadastrar uma nova pessoa.
     *
     * save():
     * salva os dados no banco de dados.
     *
     * Se o ID estiver vazio:
     * -> cria um novo registro
     *
     * Se o ID existir:
     * -> atualiza o registro
     */

    public PessoaModel criarPessoa(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

}