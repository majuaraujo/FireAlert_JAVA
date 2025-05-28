package com.maria.firealert.firealert_api.controller;

import com.maria.firealert.firealert_api.model.Ocorrencia;
import com.maria.firealert.firealert_api.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @GetMapping
    public List<Ocorrencia> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> criar(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.ok(service.salvar(ocorrencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por agente
    @GetMapping("/por-agente/{agenteId}")
    public ResponseEntity<List<Ocorrencia>> buscarPorAgente(@PathVariable Long agenteId) {
        List<Ocorrencia> ocorrencias = service.buscarPorAgente(agenteId);
        if (ocorrencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ocorrencias);
    }
}

