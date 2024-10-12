package pe.edu.cibertec.security_app_t2.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.security_app_t2.model.Paciente;
import pe.edu.cibertec.security_app_t2.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    // Constructor para inyectar el repositorio
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // Método para crear un nuevo paciente
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Método para listar todos los pacientes
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Método para actualizar un paciente existente
    public Paciente actualizarPaciente(Long id, Paciente paciente) {
        Paciente pacienteActual = pacienteRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        pacienteActual.setNombrePac(paciente.getNombrePac());
        pacienteActual.setApellido(paciente.getApellido());
        pacienteActual.setDni(paciente.getDni());
        pacienteActual.setDireccion(paciente.getDireccion());
        pacienteActual.setTelefono(paciente.getTelefono());
        pacienteActual.setCorreo(paciente.getCorreo());

        return pacienteRepository.save(pacienteActual);
    }
}
