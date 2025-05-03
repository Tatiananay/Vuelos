package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import vuelos.example.Vuelos.modelo.Usuario;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByCorreoAndPasswordAndNombre(
        String correo,
        String password,
        String nombre
    );
}
