package br.ucsal.espacoFisico_ms.model.service;

import br.ucsal.espacoFisico_ms.dto.EspacoAcademicoDTO;
import br.ucsal.espacoFisico_ms.model.entity.EspacoAcademico;
import br.ucsal.espacoFisico_ms.model.entity.SituacaoEspaco;
import br.ucsal.espacoFisico_ms.model.repository.EspacoAcademicoRepository;
import br.ucsal.espacoFisico_ms.model.validation.EspacoAcademicoValidation;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EspacoAcademicoService {

    private EspacoAcademicoRepository espacoAcademicoRepository;
    private EspacoAcademicoValidation espacoAcademicoValidation;
    private WebClient softwareWebClient;

    public EspacoAcademicoService(EspacoAcademicoRepository espacoAcademicoRepository,
            EspacoAcademicoValidation espacoAcademicoValidation, WebClient softwareWebClient) {

        this.espacoAcademicoRepository = espacoAcademicoRepository;
        this.espacoAcademicoValidation = espacoAcademicoValidation;
        this.softwareWebClient = softwareWebClient;
    }

    public EspacoAcademico create(EspacoAcademicoDTO dto) {
        return espacoAcademicoRepository.save(new EspacoAcademico(dto));
    }

    public EspacoAcademico update(Long id, EspacoAcademicoDTO dto) {
        EspacoAcademico espaco = findById(id);
        espaco.setSituacaoEspaco(dto.situacaoEspaco());
        espaco.setNome(dto.nome());
        espaco.setSigla(dto.sigla());
        espaco.setDescricao(dto.descricao());
        espaco.setCapacidadeMaxima(dto.capacidadeMaxima());
        espaco.setLocalizacao(dto.localizacao());
        espaco.setSoftwareIds(dto.softwareIds());

        return espacoAcademicoRepository.save(espaco);
    }

    public void delete(Long id) {
        if (!espacoAcademicoRepository.existsById(id)) {
            throw new NoSuchElementException("Espaço não encontrado");
        }
        espacoAcademicoRepository.deleteById(id);
    }

    public EspacoAcademico findById(Long id) {
        return espacoAcademicoRepository.findById(id).get();
    }

    public List<EspacoAcademico> findAll() {
        return espacoAcademicoRepository.findAll();
    }

    public List<EspacoAcademico> findAtivo() {
        List<EspacoAcademico> espacosAtivos = new ArrayList<EspacoAcademico>();
        for (EspacoAcademico espacoAtivo : findAll()) {
            if (espacoAtivo.getSituacaoEspaco() == SituacaoEspaco.Ativo)
                espacosAtivos.add(espacoAtivo);
        }
        return espacosAtivos;
    }

    public List<EspacoAcademico> findInativo() {
        List<EspacoAcademico> espacosInativos = new ArrayList<EspacoAcademico>();
        for (EspacoAcademico espacoInativo : findAll()) {
            if (espacoInativo.getSituacaoEspaco() == SituacaoEspaco.Inativo)
                espacosInativos.add(espacoInativo);
        }
        return espacosInativos;
    }

    // pega somente pelo id sem precisar do SoftwareService
    public EspacoAcademico addSoftwareId(Long idEspaco, Long idSoftware) {
        EspacoAcademico espaco = findById(idEspaco);

        if (!espaco.getSoftwareIds().contains(idSoftware)) {
            espaco.getSoftwareIds().add(idSoftware);
        }
        return espacoAcademicoRepository.save(espaco);
    }

}
