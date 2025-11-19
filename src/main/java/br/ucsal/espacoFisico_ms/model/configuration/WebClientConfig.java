package br.ucsal.espacoFisico_ms.model.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient softwareWebClient() {
        return loadBalancedWebClientBuilder().baseUrl("http://MICROSERVICO-SOFTWARE").build();
    }

    @Bean
    public WebClient reservasWebClient() {
        return loadBalancedWebClientBuilder().baseUrl("http://MICROSERVICO-RESERVAS").build();
    }
}