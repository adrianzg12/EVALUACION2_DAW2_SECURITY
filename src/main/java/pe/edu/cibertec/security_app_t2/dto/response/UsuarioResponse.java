package pe.edu.cibertec.security_app_t2.dto.response

        ;

import lombok.Builder;
import lombok.Data;
import pe.edu.cibertec.security_app_t2.model.Usuario;

@Data
@Builder
public class UsuarioResponse {
    private Long id;
    private String codigo;
    private String rol;
    private String mensaje;
    private String tiempoExpiracion;
    private String token;
    private Usuario usuario;
}
