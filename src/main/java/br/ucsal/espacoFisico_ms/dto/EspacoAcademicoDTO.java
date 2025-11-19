package br.ucsal.espacoFisico_ms.dto;

import br.ucsal.espacoFisico_ms.model.entity.SituacaoEspaco;

import java.util.List;

public record EspacoAcademicoDTO(
        Long id,
        String sigla,
        String nome,
        String descricao,
        int capacidadeMaxima,
        String localizacao,
        List<Long> softwareIds,
        SituacaoEspaco situacaoEspaco
) {
}
