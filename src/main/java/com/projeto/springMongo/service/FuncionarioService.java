package com.projeto.springMongo.service;

import com.projeto.springMongo.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar(Funcionario funcionario);

    public List<Funcionario> obterFuncinoariosPorRangeDeIdade(Integer de, Integer ate);

    public List<Funcionario> obterFuncinoariosPorNome(String nome);

}
