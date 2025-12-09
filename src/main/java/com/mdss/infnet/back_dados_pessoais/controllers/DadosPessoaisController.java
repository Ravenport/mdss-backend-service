package com.mdss.infnet.back_dados_pessoais.controllers;

import com.mdss.infnet.back_dados_pessoais.DTOs.DadosPessoaisCompletosDTO;
import com.mdss.infnet.back_dados_pessoais.services.DadosPessoaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dados-pessoais")
public class DadosPessoaisController {

    private DadosPessoaisService dadosPessoaisService;

    public DadosPessoaisController(DadosPessoaisService dadosPessoaisService) {
        this.dadosPessoaisService = dadosPessoaisService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisCompletosDTO> getDadosPessoais(@PathVariable String cpf) {
        DadosPessoaisCompletosDTO dadosPessoaisDTO = dadosPessoaisService.getDadosPessoais(cpf);
        return ResponseEntity.ok(dadosPessoaisDTO);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarDadosPessoais(@RequestBody DadosPessoaisCompletosDTO dadosCompletos) {
        dadosPessoaisService.cadastrarDadosPessoais(dadosCompletos);
        return ResponseEntity.ok("Dados Pessoais Cadastrados com Sucesso!");
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deletarDadosPessoais(@PathVariable String cpf) {
        dadosPessoaisService.deletarDadosPessoais(cpf);
        return ResponseEntity.ok("Dados Pessoais Deletados com Sucesso!");
    }
}
