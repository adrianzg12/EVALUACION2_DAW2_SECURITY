package pe.edu.cibertec.security_app_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.security_app_t2.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Long> {
    Optional<Usuario> findByCodigo(String codigo);
}
