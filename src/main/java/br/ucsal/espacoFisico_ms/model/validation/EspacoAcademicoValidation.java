package br.ucsal.espacoFisico_ms.model.validation;

import br.ucsal.espacoFisico_ms.dto.EspacoAcademicoDTO;
import org.springframework.stereotype.Component;

@Component
public class EspacoAcademicoValidation {

    public boolean existId(EspacoAcademicoDTO dto) {
        return dto != null;
    }
}