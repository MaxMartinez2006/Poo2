package org.maxmartinez.apihospital.controller;


import org.maxmartinez.apihospital.model.Diagnostico;
import org.maxmartinez.apihospital.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    // GET: listar todos los diagnósticos
    @GetMapping
    public List<Diagnostico> listarDiagnosticos() {
        return diagnosticoService.obtenerTodos();
    }

    // GET: obtener diagnóstico por ID
    @GetMapping("/id")
    public ResponseEntity<Diagnostico> obtenerPorId(@PathVariable Long id) {
        Optional<Diagnostico> diagnostico = diagnosticoService.obtenerPorId(id);
        return diagnostico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: crear nuevo diagnóstico
    @PostMapping
    public Diagnostico crearDiagnostico(@RequestBody Diagnostico diagnostico) {
        return diagnosticoService.guardar(diagnostico);
    }
}