package com.maria.firealert.firealert_api.controller;

import com.maria.firealert.firealert_api.model.Alerta;
import com.maria.firealert.firealert_api.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService service;

    // ✅ Suporte ao filtro por status (?status=ativo)
    @GetMapping
    public List<Alerta> listarTodos(@RequestParam(required = false) String status) {
        if (status != null) {
            return service.buscarPorStatus(status);
        }
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alerta> criar(@RequestBody Alerta alerta) {
        return ResponseEntity.ok(service.salvar(alerta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

