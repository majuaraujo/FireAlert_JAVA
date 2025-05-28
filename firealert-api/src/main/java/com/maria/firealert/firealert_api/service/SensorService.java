package com.maria.firealert.firealert_api.service;

import com.maria.firealert.firealert_api.model.Sensor;
import com.maria.firealert.firealert_api.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> buscarPorId(Long id) {
        return sensorRepository.findById(id);
    }

    public Sensor salvar(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public void deletar(Long id) {
        sensorRepository.deleteById(id);
    }
}
