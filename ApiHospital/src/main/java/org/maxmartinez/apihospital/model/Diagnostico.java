package org.maxmartinez.apihospital.model;


import jakarta.persistence.*;
import org.maxmartinez.apihospital.model.Cita;

import java.time.LocalDate;

@Entity
@Table(name = "diagnosticos")

public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(name = "fecha_diagnostico")
    private LocalDate fecha;

    // Relación uno a uno con Cita
    @OneToOne
    @JoinColumn(name = "cita_id", referencedColumnName = "id")
    private Cita cita;

    // Constructor vacío
    public Diagnostico() {}

    // Constructor completo
    public Diagnostico(String descripcion, LocalDate fecha, Cita cita) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cita = cita;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}



