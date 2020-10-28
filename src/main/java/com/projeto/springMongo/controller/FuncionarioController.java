package com.projeto.springMongo.controller;

import com.projeto.springMongo.model.Funcionario;
import com.projeto.springMongo.repository.FuncionarioRepository;
import com.projeto.springMongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos(){
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo){
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario){
        return this.funcionarioService.criar(funcionario);
    }

    @GetMapping("/range")
    public List<Funcionario> obterFuncinoariosPorRangeDeIdade(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate){
        return this.funcionarioService.obterFuncinoariosPorRangeDeIdade(de,ate);
    }

    @GetMapping("/por-nome")
    public List<Funcionario> obterFuncinoariosPorNome(
            @RequestParam("nome") String nome){
        return this.funcionarioService.obterFuncinoariosPorNome(nome);
    }
}
