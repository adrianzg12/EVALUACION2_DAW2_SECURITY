package pe.edu.cibertec.security_app_t2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.security_app_t2.model.Paciente;
import pe.edu.cibertec.security_app_t2.service.impl.PacienteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    // Listar todos los pacientes (solo usuarios con rol COORDINADOR pueden acceder)
    @PreAuthorize("hasRole('COORDINADOR')")
    @GetMapping("/findAll")
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    // Crear un nuevo paciente (solo usuarios con autoridad GESTOR pueden acceder)
    @PreAuthorize("hasAuthority('GESTOR')")
    @PostMapping("/crear")
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));
    }

    // Actualizar un paciente existente (GESTOR y COORDINADOR pueden acceder)
    @PreAuthorize("hasRole('GESTOR') or hasRole('COORDINADOR')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente, @PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.actualizarPaciente(id, paciente));
    }
}