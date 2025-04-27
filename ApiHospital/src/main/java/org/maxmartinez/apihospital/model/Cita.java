package org.maxmartinez.apihospital.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table (name = "citas")

public class Cita {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fecha;
    private LocalTime hora;
    private String motivo;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    public enum EstadoCita {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA,
        COMPLETADA
    }
    //constructor vacio

    public Cita() {
    }

    //constructores
    public Cita(long id, LocalDateTime fecha, LocalTime hora, String motivo, EstadoCita estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    //getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
}

