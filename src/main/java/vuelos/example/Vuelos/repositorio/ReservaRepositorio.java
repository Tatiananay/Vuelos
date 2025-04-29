package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import vuelos.example.Vuelos.modelo.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
}
