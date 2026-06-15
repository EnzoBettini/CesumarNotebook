package com.example.demo.controllers;

import com.example.demo.models.PessoaModel;
import com.example.demo.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaModel> buscarPessoa() {
        return pessoaService.buscarPessoa();
    }

    @PostMapping
    public PessoaModel buscarPessoa(@RequestBody PessoaModel pessoaModel) {
        return pessoaService.criarPessoa(pessoaModel);
    }
}
