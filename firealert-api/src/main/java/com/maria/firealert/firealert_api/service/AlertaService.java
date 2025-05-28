package com.maria.firealert.firealert_api.service;

import com.maria.firealert.firealert_api.model.Alerta;
import com.maria.firealert.firealert_api.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository repository;

    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        return repository.save(alerta);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // 🔍 Filtro por status (ex: ativo, resolvido)
    public List<Alerta> buscarPorStatus(String status) {
        return repository.findByStatusIgnoreCase(status);
    }
}

