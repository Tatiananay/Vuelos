package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import vuelos.example.Vuelos.modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
}
