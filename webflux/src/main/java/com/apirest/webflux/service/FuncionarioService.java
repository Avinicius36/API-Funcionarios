package com.apirest.webflux.service;

import com.apirest.webflux.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar(Funcionario funcionario);

    public void deletarFuncionario(String codigo);

    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate);

    public List<Funcionario> obterFuncionarioPorNome(String nome);
}
