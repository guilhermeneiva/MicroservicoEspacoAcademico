package br.ucsal.espacoFisico_ms.controller;

import br.ucsal.espacoFisico_ms.dto.EspacoAcademicoDTO;
import br.ucsal.espacoFisico_ms.model.entity.EspacoAcademico;
import br.ucsal.espacoFisico_ms.model.service.EspacoAcademicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacos")
public class EspacoAcademicoController {

    EspacoAcademicoService espacoAcademicoService;

    public EspacoAcademicoController(EspacoAcademicoService espacoAcademicoService) {
        this.espacoAcademicoService = espacoAcademicoService;
    }

    @PostMapping
    public ResponseEntity<EspacoAcademico> create(@Valid @RequestBody EspacoAcademicoDTO dto) {
        EspacoAcademico novoEspaco = espacoAcademicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEspaco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspacoAcademico> update(@PathVariable Long id, @Valid @RequestBody EspacoAcademicoDTO dto) {
        EspacoAcademico espacoAtualizado = espacoAcademicoService.update(id, dto);
        return ResponseEntity.ok(espacoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EspacoAcademico> delete(@PathVariable Long id) {
        espacoAcademicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EspacoAcademico> findById(@PathVariable Long id) {
        return ResponseEntity.ok(espacoAcademicoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EspacoAcademico>> findAll() {
        return ResponseEntity.ok(espacoAcademicoService.findAll());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<EspacoAcademico>> findAtivo() {
        return ResponseEntity.ok(espacoAcademicoService.findAtivo());
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<EspacoAcademico>> findInativo() {
        return ResponseEntity.ok(espacoAcademicoService.findInativo());
    }

}
