package com.maria.firealert.firealert_api.repository;

import com.maria.firealert.firealert_api.model.AgenteAmbiental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteAmbientalRepository extends JpaRepository<AgenteAmbiental, Long> {
}
