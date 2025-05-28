package com.maria.firealert.firealert_api.service;

import com.maria.firealert.firealert_api.model.AgenteAmbiental;
import com.maria.firealert.firealert_api.repository.AgenteAmbientalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteAmbientalService {

    @Autowired
    private AgenteAmbientalRepository repository;

    public List<AgenteAmbiental> listarTodos() {
        return repository.findAll();
    }

    public Optional<AgenteAmbiental> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public AgenteAmbiental salvar(AgenteAmbiental agente) {
        return repository.save(agente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
