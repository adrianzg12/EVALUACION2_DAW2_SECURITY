package pe.edu.cibertec.security_app_t2.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    private int idPaciente;
    private String nombrePac;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String correo;
}
