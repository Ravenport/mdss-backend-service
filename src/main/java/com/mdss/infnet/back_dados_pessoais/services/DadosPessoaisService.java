package com.mdss.infnet.back_dados_pessoais.services;

import com.mdss.infnet.back_dados_pessoais.DTOs.DadosPessoaisCompletosDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DadosPessoaisService {
    private final RestTemplate restTemplate;

    @Value("${DATA_SERVICE_URL}")
    private String dataServiceUrl;

    public DadosPessoaisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DadosPessoaisCompletosDTO getDadosPessoais(String cpf) {
        ParameterizedTypeReference<DadosPessoaisCompletosDTO> typeReference = new ParameterizedTypeReference<>() {};
        DadosPessoaisCompletosDTO dadosPessoaisCompletos = restTemplate.exchange(
                dataServiceUrl + "/api/data/dados-pessoais/{cpf}",
                HttpMethod.GET,
                null,
                typeReference,
                cpf
        ).getBody();

        if(dadosPessoaisCompletos != null) {
            return dadosPessoaisCompletos;
        } else {
            throw new IllegalArgumentException("O cpf não está cadastrado no sistema.");
        }
    }

    public String cadastrarDadosPessoais(DadosPessoaisCompletosDTO dadosCompletos) {
        try {
            ParameterizedTypeReference<DadosPessoaisCompletosDTO> typeReference = new ParameterizedTypeReference<>() {};
            restTemplate.exchange(
                    dataServiceUrl + "/api/data/dados-pessoais",
                    HttpMethod.POST,
                    null,
                    typeReference,
                    dadosCompletos
            );

            return "Dados Pessoais Cadastrados com Sucesso!";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deletarDadosPessoais(String cpf) {
        try {
            ParameterizedTypeReference<DadosPessoaisCompletosDTO> typeReference = new ParameterizedTypeReference<>() {};
            restTemplate.exchange(
                    dataServiceUrl + "/api/data/dados-pessoais/{cpf}",
                    HttpMethod.DELETE,
                    null,
                    typeReference,
                    cpf
            );

            return "Dados Pessoais Excluidos com Sucesso!";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
