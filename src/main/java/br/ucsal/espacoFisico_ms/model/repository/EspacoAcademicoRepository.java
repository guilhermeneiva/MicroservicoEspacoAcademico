package br.ucsal.espacoFisico_ms.model.repository;

import br.ucsal.espacoFisico_ms.model.entity.EspacoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacoAcademicoRepository extends JpaRepository<EspacoAcademico, Long> {
}
