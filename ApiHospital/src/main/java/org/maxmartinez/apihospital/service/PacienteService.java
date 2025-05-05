package org.maxmartinez.apihospital.service;



import org.maxmartinez.apihospital.model.Paciente;
import org.maxmartinez.apihospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Listar todos
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    // Buscar por ID
    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Guardar nuevo o actualizar
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Eliminar
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}


