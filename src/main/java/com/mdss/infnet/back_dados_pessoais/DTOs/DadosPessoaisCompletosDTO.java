package com.mdss.infnet.back_dados_pessoais.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DadosPessoaisCompletosDTO {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
}
