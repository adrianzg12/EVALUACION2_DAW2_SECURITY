package pe.edu.cibertec.security_app_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.security_app_t2.model.Paciente;
import pe.edu.cibertec.security_app_t2.model.Usuario;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
