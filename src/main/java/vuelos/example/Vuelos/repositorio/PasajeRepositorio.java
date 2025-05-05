package vuelos.example.Vuelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vuelos.example.Vuelos.modelo.Pasaje;

import java.util.List;

@Repository
public interface PasajeRepositorio extends JpaRepository<Pasaje, Integer> {
    //List<Pasaje> findById_Vuelo(Integer idVuelo);

}
