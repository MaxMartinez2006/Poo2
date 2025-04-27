package org.maxmartinez.apihospital.controller;


import org.maxmartinez.apihospital.model.Receta;
import org.maxmartinez.apihospital.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    private org.maxmartinez.apihospital.controller.RecetaService recetaService;

    // GET: listar todas las recetas
    @GetMapping
    public List<Receta> listarRecetas() {
        return recetaService.obtenerTodas();
    }

    // GET: obtener receta por ID
    @GetMapping("/id")
    public ResponseEntity<Receta> obtenerPorId(@PathVariable Long id) {
        Optional<Receta> receta = recetaService.obtenerPorId(id);
        return receta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: crear nueva receta
    @PostMapping
    public Receta crearReceta(@RequestBody Receta receta) {
        return recetaService.guardar(receta);
    }
}