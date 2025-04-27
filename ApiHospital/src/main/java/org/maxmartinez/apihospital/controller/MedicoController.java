package org.maxmartinez.apihospital.controller;

import org.maxmartinez.apihospital.model.Medico;
import org.maxmartinez.apihospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amedicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // GET: listar todos los médicos
    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoService.obtenerTodos();
    }

    // GET: obtener médico por ID
    @GetMapping("/id")
    public ResponseEntity<Medico> obtenerPorId(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.obtenerPorId(id);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: crear nuevo médico
    @PostMapping
    public Medico crearMedico(@RequestBody Medico medico) {
        return medicoService.guardar(medico);
    }
}
