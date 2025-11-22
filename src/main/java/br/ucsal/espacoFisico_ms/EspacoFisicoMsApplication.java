package br.ucsal.espacoFisico_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EspacoFisicoMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspacoFisicoMsApplication.class, args);
    }

}
