package com.maria.firealert.firealert_api.controller;

import com.maria.firealert.firealert_api.model.PontoDeFoco;
import com.maria.firealert.firealert_api.service.PontoDeFocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/focos")
public class PontoDeFocoController {

    @Autowired
    private PontoDeFocoService service;

    @GetMapping
    public List<PontoDeFoco> listarTodos(@RequestParam(required = false) Double minIntensidade) {
        if (minIntensidade != null) {
            return service.buscarPorIntensidadeMinima(minIntensidade);
        }
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoDeFoco> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PontoDeFoco> criar(@RequestBody PontoDeFoco foco) {
        return ResponseEntity.ok(service.salvar(foco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

