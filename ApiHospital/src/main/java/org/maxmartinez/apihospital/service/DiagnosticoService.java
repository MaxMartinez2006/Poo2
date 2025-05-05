package org.maxmartinez.apihospital.service;

import org.maxmartinez.apihospital.model.Diagnostico;
import org.maxmartinez.apihospital.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    // Listar todos
    public List<Diagnostico> obtenerTodos() {
        return diagnosticoRepository.findAll();
    }

    // Buscar por ID
    public Optional<Diagnostico> obtenerPorId(Long id) {
        return diagnosticoRepository.findById(id);
    }

    // Guardar nuevo
    public Diagnostico guardar(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    // Eliminar
    public void eliminar(Long id) {
        diagnosticoRepository.deleteById(id);
    }
}


