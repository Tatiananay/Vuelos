package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import vuelos.example.Vuelos.modelo.Vuelo;

public interface VueloRepositorio extends JpaRepository<Vuelo, Integer> {
}
