package com.apirest.webflux.service;

import com.apirest.webflux.model.Funcionario;
import com.apirest.webflux.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
       return this.funcionarioRepository.findById(codigo).
                orElseThrow(() -> new IllegalArgumentException("Funcionario não existe"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        Funcionario chefe = this.funcionarioRepository
                .findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe Inexistente"));

        funcionario.setChefe(chefe);

        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public void deletarFuncionario(String codigo) {
        this.funcionarioRepository.deleteById(codigo);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
        return this.funcionarioRepository.obterFuncionariosPorRangeDeIdade(de, ate);
    }

    @Override
    public List<Funcionario> obterFuncionarioPorNome(String nome) {
        return this.funcionarioRepository.findByNome(nome);
    }
}
