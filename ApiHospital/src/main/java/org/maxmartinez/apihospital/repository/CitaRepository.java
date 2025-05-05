package org.maxmartinez.apihospital.repository;

import org.maxmartinez.apihospital.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Verifica si ya hay una cita para un médico en una fecha y hora específicas
    boolean existsByMedicoIdAndFechaAndHora(Long medicoId, LocalDateTime fecha, LocalTime hora);

    // Busca las citas de un paciente después de una fecha específica
    List<Cita> findByPacienteIdAndFechaAfter(Long pacienteId, LocalDateTime fecha);
}
