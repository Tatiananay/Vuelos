package vuelos.example.Vuelos.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vuelos.example.Vuelos.modelo.Usuario;
import vuelos.example.Vuelos.servicio.IUsuarioServicio;

import java.util.List;


@RestController
@RequestMapping("vuelo-app")
@CrossOrigin("http://localhost:3000")
public class ControladorUsuario {

    private static final Logger logger= LoggerFactory.getLogger(ControladorUsuario.class);
    @Autowired
    private IUsuarioServicio usuarioServicio;

    // Usuarios

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioServicio.listarUsuario();
    }

    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        logger.info("Guardando usuario");
        return usuarioServicio.guardarUsuario(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorId(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        String password = usuario.getPassword();
        String correo = usuario.getCorreo();
        String nombre = usuario.getNombre();

        Usuario usuario1 = usuarioServicio.Login(correo,password,nombre);
        if (usuario1 == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(usuario1);
    }

}
