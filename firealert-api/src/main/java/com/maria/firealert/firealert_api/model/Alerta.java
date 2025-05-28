package com.maria.firealert.firealert_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private String status; // "ativo", "resolvido", "em análise"

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataEmissao;

    @ManyToOne
    @JoinColumn(name = "ponto_de_foco_id", nullable = false)
    private PontoDeFoco pontoDeFoco;
}

