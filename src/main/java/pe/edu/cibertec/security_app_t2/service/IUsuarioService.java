package pe.edu.cibertec.security_app_t2.service
        ;

import pe.edu.cibertec.security_app_t2.dto.response.UsuarioResponse;
import pe.edu.cibertec.security_app_t2.dto.response.login.LoginDto;
import pe.edu.cibertec.security_app_t2.model.Usuario;

public interface IUsuarioService {
    UsuarioResponse registrarUsuario(Usuario usuario);
    UsuarioResponse loginUsuario(LoginDto login);
}
