package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import vuelos.example.Vuelos.modelo.Pasaje;

public interface PasajeRepositorio extends JpaRepository<Pasaje, Integer> {
}
