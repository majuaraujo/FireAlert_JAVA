package com.maria.firealert.firealert_api.service;

import com.maria.firealert.firealert_api.model.PontoDeFoco;
import com.maria.firealert.firealert_api.repository.PontoDeFocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoDeFocoService {

    @Autowired
    private PontoDeFocoRepository repository;

    public List<PontoDeFoco> listarTodos() {
        return repository.findAll();
    }

    public Optional<PontoDeFoco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public PontoDeFoco salvar(PontoDeFoco foco) {
        return repository.save(foco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // 🔍 Filtro por intensidade mínima
    public List<PontoDeFoco> buscarPorIntensidadeMinima(Double valor) {
        return repository.findByIntensidadeGreaterThanEqual(valor);
    }
}
