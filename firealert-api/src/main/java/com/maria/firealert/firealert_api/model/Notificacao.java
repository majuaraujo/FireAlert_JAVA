package com.maria.firealert.firealert_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private String tipo; // leve, moderada, critica

    private LocalDateTime dataHora;

    @ManyToOne
    private PontoDeFoco pontoDeFoco;
}
