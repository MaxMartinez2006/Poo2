package org.maxmartinez.apihospital.service;

import org.maxmartinez.apihospital.model.Cita;
import org.maxmartinez.apihospital.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    // Listar todas las citas
    public List<Cita> obtenerTodas() {
        return citaRepository.findAll();
    }

    // Buscar cita por ID
    public Optional<Cita> obtenerPorId(Long id) {
        return citaRepository.findById(id);
    }

    // Crear o actualizar cita
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    // Eliminar cita
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}



