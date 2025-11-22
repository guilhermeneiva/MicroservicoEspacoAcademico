package br.ucsal.espacoFisico_ms.model.validation;

import br.ucsal.espacoFisico_ms.dto.EspacoAcademicoDTO;
import br.ucsal.espacoFisico_ms.feign.EspacoInterface;
import br.ucsal.espacoFisico_ms.model.exception.NaoExisteException;

import org.springframework.stereotype.Component;

@Component
public class EspacoAcademicoValidation {

    private EspacoInterface espacoInterface;

    public EspacoAcademicoValidation(EspacoInterface espacoInterface) {
        this.espacoInterface = espacoInterface;
    }

    public boolean existId(EspacoAcademicoDTO dto) {
        return dto != null;
    }

    public void existsSoftware(EspacoAcademicoDTO dto) {
        for (Long id : dto.softwareIds()) {
            if (!espacoInterface.exists(id)) {
                throw new NaoExisteException("O software de id " + id + " não existe");
            }
        }
    }
}
