package org.maxmartinez.apihospital.controller;


import org.maxmartinez.apihospital.model.Paciente;
import org.maxmartinez.apihospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apaciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // GET: listar todos los pacientes
    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.obtenerTodos();
    }

    // GET: obtener paciente por ID
    @GetMapping("/id")
    public ResponseEntity<Paciente> obtenerPorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.obtenerPorId(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: crear nuevo paciente
    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }
}



