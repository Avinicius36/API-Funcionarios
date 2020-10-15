package com.apirest.webflux.controller;

import com.apirest.webflux.model.Funcionario;
import com.apirest.webflux.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCódigo(@PathVariable String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.criar(funcionario);
    }

    @DeleteMapping("/{codigo}")
    public void deletarFuncionario(@PathVariable String codigo) {
        this.funcionarioService.deletarFuncionario(codigo);
    }

    @GetMapping("/range")
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(@RequestParam("de") Integer de, @RequestParam("ate") Integer ate) {
        return this.funcionarioService.obterFuncionariosPorRangeDeIdade(de, ate);
    }

    @GetMapping("/por-nome")
    public List<Funcionario> obterFuncionariosPorNome(@RequestParam("nome") String nome) {
        return this.funcionarioService.obterFuncionarioPorNome(nome);
    }
}
