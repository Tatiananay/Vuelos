package vuelos.example.Vuelos.servicio;

import vuelos.example.Vuelos.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuario();
    public Usuario guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public Usuario Login(String correo, String password);
    public Usuario obtenerUsuarioPorId(Integer id);
}
