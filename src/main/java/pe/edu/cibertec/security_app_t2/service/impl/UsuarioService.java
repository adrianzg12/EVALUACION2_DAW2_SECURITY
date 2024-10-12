package pe.edu.cibertec.security_app_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.security_app_t2.dto.response.UsuarioResponse;
import pe.edu.cibertec.security_app_t2.dto.response.login.LoginDto;
import pe.edu.cibertec.security_app_t2.model.Usuario;
import pe.edu.cibertec.security_app_t2.repository.UsuarioRepository;
import pe.edu.cibertec.security_app_t2.security.jwt.JwtUtil;
import pe.edu.cibertec.security_app_t2.service.IUsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @Override
    public UsuarioResponse registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario usuarioSaved = this.usuarioRepository.save(usuario);

        return UsuarioResponse.builder()
                .mensaje("Usuario registrado")
                .codigo(usuarioSaved.getCodigo())
                .build();
    }


    @Override
    public UsuarioResponse loginUsuario(LoginDto login) {
        Usuario usuario = this.usuarioRepository.findByCodigo(login.getCodigo()).orElseThrow(
                () -> new RuntimeException("El Usuario no a sido  encontrado")
        );

        if (!passwordEncoder.matches(login.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña invalida");
        }

        String token = this.jwtUtil.generarToken(usuario);

        return UsuarioResponse.builder()
                .mensaje("Usuario logeado exitosamente")
                .codigo(usuario.getCodigo())
                .rol(usuario.getRol().name())
                .tiempoExpiracion("3 minutos")
                .token(token)
                .build();
    }
}
