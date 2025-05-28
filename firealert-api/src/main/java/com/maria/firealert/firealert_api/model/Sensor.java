package com.maria.firealert.firealert_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // classe representa a tabela no banco
@Data   // criação getters, setters, toString, etc.
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto preenchimento do ID
    private Long id;

    private String tipo; // Ex: "fumaça", "temperatura"

    private String latitude;
    private String longitude;

    private boolean ativo;


}

