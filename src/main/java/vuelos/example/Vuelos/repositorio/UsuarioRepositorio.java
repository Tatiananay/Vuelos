package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import vuelos.example.Vuelos.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
