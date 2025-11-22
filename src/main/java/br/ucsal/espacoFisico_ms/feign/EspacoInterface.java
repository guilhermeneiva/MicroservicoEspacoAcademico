package br.ucsal.espacoFisico_ms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SOFTWARE", url = "http://localhost:8001/software")
public interface EspacoInterface {

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable Long id);

}
