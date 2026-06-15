package com.spring.security.controllers;

import com.spring.security.models.PessoaModel;
import com.spring.security.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaModel> findAll(){
        return  pessoaService.findAll();
    }
    @PostMapping
    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoaModel){
        return  pessoaService.criarPessoa(pessoaModel);
    }




}
