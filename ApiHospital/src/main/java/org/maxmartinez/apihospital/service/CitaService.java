package org.maxmartinez.apihospital.service;

import org.maxmartinez.apihospital.model.Cita;
import org.maxmartinez.apihospital.repository.CitaRepository;
import org.maxmartinez.apihospital.repository.MedicoRepository;
import org.maxmartinez.apihospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Listar todas las citas
    public List<Cita> obtenerTodas() {
        return citaRepository.findAll();
    }

    // Buscar cita por ID
    public Optional<Cita> obtenerPorId(Long id) {
        return citaRepository.findById(id);
    }

    // Validar disponibilidad del médico
    private boolean validarDisponibilidadMedico(Long medicoId, LocalDateTime fecha, LocalTime hora) {
        return !citaRepository.existsByMedicoIdAndFechaAndHora(medicoId, fecha, hora);
    }

    // Validar si el paciente ya tiene citas a esa hora
    private boolean validarCitasPaciente(Long pacienteId, LocalDateTime fecha) {
        return citaRepository.findByPacienteIdAndFechaAfter(pacienteId, fecha).isEmpty();
    }

    // Crear o actualizar cita con validaciones
    public Cita guardar(Cita cita) throws Exception {
        // Validación: asegurarse de que el médico esté disponible
        if (!validarDisponibilidadMedico(cita.getMedico().getId(), cita.getFecha(), cita.getHora())) {
            throw new Exception("El médico no está disponible en esa fecha y hora.");
        }

        // Validación: asegurarse de que el paciente no tenga citas duplicadas
        if (!validarCitasPaciente(cita.getPaciente().getId(), cita.getFecha())) {
            throw new Exception("El paciente ya tiene una cita programada a esa hora.");
        }

        // Validación: asegurarse de que la fecha y hora sean futuras
        if (cita.getFecha().isBefore(LocalDateTime.now())) {
            throw new Exception("La fecha y hora de la cita deben ser en el futuro.");
        }

        // Si todo es válido, guardamos la cita
        return citaRepository.save(cita);
    }

    // Eliminar cita
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}
