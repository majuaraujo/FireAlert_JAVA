package com.maria.firealert.firealert_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AgenteAmbiental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String matricula;

    private String email;

    private String areaAtuacao;
}

