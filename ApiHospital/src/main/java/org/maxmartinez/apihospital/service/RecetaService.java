package org.maxmartinez.apihospital.service;

import org.maxmartinez.apihospital.model.Receta;
import org.maxmartinez.apihospital.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;

    @Autowired
    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    // Método para obtener todas las recetas
    public List<Receta> obtenerTodasLasRecetas() {
        return recetaRepository.findAll();
    }

    // Método para obtener una receta por su ID
    public Optional<Receta> obtenerRecetaPorId(Long id) {
        return recetaRepository.findById(id);
    }

    // Método para guardar una nueva receta
    public Receta guardarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    // Método para actualizar una receta existente
    public Receta actualizarReceta(Long id, Receta recetaActualizada) {
        if (recetaRepository.existsById(id)) {
            recetaActualizada.setId(id);
            return recetaRepository.save(recetaActualizada);
        } else {
            throw new RuntimeException("Receta no encontrada con id " + id);
        }
    }

    // Método para eliminar una receta por su ID
    public void eliminarReceta(Long id) {
        if (recetaRepository.existsById(id)) {
            recetaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Receta no encontrada con id " + id);
        }
    }
}
