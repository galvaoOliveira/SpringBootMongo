package com.projeto.springMongo.service.impl;

import com.projeto.springMongo.model.Funcionario;
import com.projeto.springMongo.repository.FuncionarioRepository;
import com.projeto.springMongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl  implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não existe"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        Funcionario chefe =
                this.funcionarioRepository
                        .findById(funcionario.getChefe().getCodigo() )
                        .orElseThrow(() -> new IllegalArgumentException("Chefe inexistente."));
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncinoariosPorRangeDeIdade(Integer de, Integer ate) {

        return this.funcionarioRepository.obterFuncinoariosPorRangeDeIdade(de,ate);
    }

    @Override
    public List<Funcionario> obterFuncinoariosPorNome(String nome) {
        return this.funcionarioRepository.findByNome(nome);
    }


}
