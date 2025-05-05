package vuelos.example.Vuelos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuelos.example.Vuelos.modelo.Usuario;
import vuelos.example.Vuelos.repositorio.UsuarioRepositorio;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);

    }

    @Override
    public Usuario Login(String correo, String password) {
        return usuarioRepositorio.findByCorreoAndPassword(correo, password)
                .orElseThrow(()-> new RuntimeException("Credenciales inválidas"));
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepositorio.findById(id).get();
    }


}
