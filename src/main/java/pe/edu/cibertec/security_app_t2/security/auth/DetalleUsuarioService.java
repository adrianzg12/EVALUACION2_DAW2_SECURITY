package pe.edu.cibertec.security_app_t2.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.security_app_t2.model.Usuario;
import pe.edu.cibertec.security_app_t2.repository.UsuarioRepository;


@Service
@RequiredArgsConstructor
public class DetalleUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByCodigo(username).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        return AuthUsuario.builder()
                .usuario(usuario)
                .build();
    }

}
