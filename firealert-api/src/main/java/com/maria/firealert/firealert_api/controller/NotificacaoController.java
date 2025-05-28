package com.maria.firealert.firealert_api.controller;

import com.maria.firealert.firealert_api.model.Notificacao;
import com.maria.firealert.firealert_api.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @GetMapping
    public List<Notificacao> listarTodas(@RequestParam(required = false) String tipo) {
        if (tipo != null) {
            return service.buscarPorTipo(tipo);
        }
        return service.listarTodas();
    }
}
