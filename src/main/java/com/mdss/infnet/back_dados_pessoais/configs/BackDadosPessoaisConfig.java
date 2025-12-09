package com.mdss.infnet.back_dados_pessoais.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BackDadosPessoaisConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
