package org.maxmartinez.apihospital.controller;

import jakarta.validation.Valid;
import org.maxmartinez.apihospital.model.Cita;
import org.maxmartinez.apihospital.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // GET: listar todas las citas
    @GetMapping
    public List<Cita> listarCitas() {
        return citaService.obtenerTodas();
    }

    // GET: obtener cita por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long id) {
        Optional<Cita> cita = citaService.obtenerPorId(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: crear nueva cita
    @PostMapping
    public ResponseEntity<?> crearCita(@Valid @RequestBody Cita cita) {
        try {
            Cita nuevaCita = citaService.guardar(cita);
            return ResponseEntity.ok(nuevaCita);
        } catch (Exception e) {
            // Capturar cualquier excepción generada por la lógica de validación en CitaService
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
