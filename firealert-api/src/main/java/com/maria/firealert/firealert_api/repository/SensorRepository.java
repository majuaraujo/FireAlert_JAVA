package com.maria.firealert.firealert_api.repository;

import com.maria.firealert.firealert_api.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

}

