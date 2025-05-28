package com.maria.firealert.firealert_api.repository;

import com.maria.firealert.firealert_api.model.PontoDeFoco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoDeFocoRepository extends JpaRepository<PontoDeFoco, Long> {
    List<PontoDeFoco> findByIntensidadeGreaterThanEqual(Double intensidade);
}
