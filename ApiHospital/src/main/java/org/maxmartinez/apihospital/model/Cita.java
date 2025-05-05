package org.maxmartinez.apihospital.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;  // Relación con la entidad Paciente

    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
    private Medico medico;  // Relación con la entidad Medico

    private LocalDateTime fecha;  // Fecha completa (fecha + hora)
    private LocalTime hora;  // Hora de la cita
    private String motivo;  // Motivo de la cita

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    public enum EstadoCita {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA,
        COMPLETADA
    }

    // Constructor vacío
    public Cita() {
    }

    // Constructor con todos los atributos
    public Cita(long id, LocalDateTime fecha, LocalTime hora, String motivo, EstadoCita estado, Paciente paciente, Medico medico) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
    }

    // Getters y setters
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

    public Paciente getPaciente() {
        return paciente;  // Aquí devolvemos el paciente asociado a la cita
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;  // Aquí devolvemos el médico asociado a la cita
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cita{");
        sb.append("id=").append(id);
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", motivo='").append(motivo).append('\'');
        sb.append(", estado=").append(estado);
        sb.append(", paciente=").append(paciente.getNombre()).append(" ").append(paciente.getApellido());
        sb.append(", medico=").append(medico.getNombre()).append(" ").append(medico.getApellido());
        sb.append('}');
        return sb.toString();
    }
}
