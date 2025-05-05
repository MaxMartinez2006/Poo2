package org.maxmartinez.apihospital.service;

import org.maxmartinez.apihospital.model.Medico;
import org.maxmartinez.apihospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Obtener todos los médicos
    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }

    // Obtener médico por ID
    public Optional<Medico> obtenerPorId(Long id) {
        return medicoRepository.findById(id);
    }

    // Guardar médico nuevo o actualizar
    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Eliminar médico
    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }
}



