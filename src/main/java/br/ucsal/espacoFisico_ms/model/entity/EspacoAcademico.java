package br.ucsal.espacoFisico_ms.model.entity;

import br.ucsal.espacoFisico_ms.dto.EspacoAcademicoDTO;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EspacoAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String sigla;

    @Nonnull
    private String nome;

    @Nonnull
    private String descricao;

    @Nonnull
    private int capacidadeMaxima;

    @Nonnull
    private String localizacao;

    @ElementCollection
    @CollectionTable(name = "espaco_software_ids", joinColumns = @JoinColumn(name = "espaco_id"))
    @Column(name = "software_id")
    private List<Long> softwareIds = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private SituacaoEspaco situacaoEspaco;

    public EspacoAcademico() {
    }


    public EspacoAcademico(EspacoAcademicoDTO dto) {
        this.id = dto.id();
        this.sigla = dto.sigla();
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.capacidadeMaxima = dto.capacidadeMaxima();
        this.localizacao = dto.localizacao();
        this.softwareIds = dto.softwareIds();
        this.situacaoEspaco = dto.situacaoEspaco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nonnull
    public String getSigla() {
        return sigla;
    }

    public void setSigla(@Nonnull String sigla) {
        this.sigla = sigla;
    }

    @Nonnull
    public String getNome() {
        return nome;
    }

    public void setNome(@Nonnull String nome) {
        this.nome = nome;
    }

    @Nonnull
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Nonnull String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    @Nonnull
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(@Nonnull String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Long> getSoftwareIds() {
        return softwareIds;
    }

    public void setSoftwareIds(List<Long> softwareIds) {
        this.softwareIds = softwareIds;
    }

    public SituacaoEspaco getSituacaoEspaco() {
        return situacaoEspaco;
    }

    public void setSituacaoEspaco(SituacaoEspaco situacaoEspaco) {
        this.situacaoEspaco = situacaoEspaco;
    }
}