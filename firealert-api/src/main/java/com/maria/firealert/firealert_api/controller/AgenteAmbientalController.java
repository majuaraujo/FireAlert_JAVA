package com.maria.firealert.firealert_api.controller;

import com.maria.firealert.firealert_api.model.AgenteAmbiental;
import com.maria.firealert.firealert_api.service.AgenteAmbientalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agentes")
public class AgenteAmbientalController {

    @Autowired
    private AgenteAmbientalService service;

    @GetMapping
    public List<AgenteAmbiental> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenteAmbiental> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgenteAmbiental> criar(@RequestBody AgenteAmbiental agente) {
        return ResponseEntity.ok(service.salvar(agente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
