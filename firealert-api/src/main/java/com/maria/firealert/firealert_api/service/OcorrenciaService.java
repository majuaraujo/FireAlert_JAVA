package com.maria.firealert.firealert_api.service;

import com.maria.firealert.firealert_api.model.Ocorrencia;
import com.maria.firealert.firealert_api.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    public List<Ocorrencia> listarTodos() {
        return repository.findAll();
    }

    public Optional<Ocorrencia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        return repository.save(ocorrencia);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // Filtro por agente
    public List<Ocorrencia> buscarPorAgente(Long agenteId) {
        return repository.findByAgenteId(agenteId);
    }
}

