package pe.edu.cibertec.security_app_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.security_app_t2.dto.response.UsuarioResponse;
import pe.edu.cibertec.security_app_t2.dto.response.login.LoginDto;
import pe.edu.cibertec.security_app_t2.model.Usuario;
import pe.edu.cibertec.security_app_t2.service.impl.UsuarioService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    /**POST PARA LOGEARSE**/
    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody LoginDto loginDTO) {
        return ResponseEntity.ok(usuarioService.loginUsuario(loginDTO));
    }

    /***POST PARA REGISTRASE**/
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }
}

