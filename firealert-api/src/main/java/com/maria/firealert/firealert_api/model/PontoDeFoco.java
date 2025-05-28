package com.maria.firealert.firealert_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class PontoDeFoco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora; // momento da detecção do foco

    private Double intensidade; // Nível de calor/fumaça

    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor; // Relação com o sensor que fez a detecção
}

