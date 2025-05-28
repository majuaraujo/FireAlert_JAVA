package com.maria.firealert.firealert_api.service;

import com.maria.firealert.firealert_api.model.Notificacao;
import com.maria.firealert.firealert_api.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    public Notificacao salvar(Notificacao notificacao) {
        return repository.save(notificacao);
    }

    public List<Notificacao> listarTodas() {
        return repository.findAll();
    }

    // 🔍 Filtro por tipo
    public List<Notificacao> buscarPorTipo(String tipo) {
        return repository.findByTipoIgnoreCase(tipo);
    }
}


