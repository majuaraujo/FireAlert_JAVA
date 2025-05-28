package com.maria.firealert.firealert_api.repository;

import com.maria.firealert.firealert_api.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByAgenteId(Long agenteId); // 🔍 Filtro por agente
}
