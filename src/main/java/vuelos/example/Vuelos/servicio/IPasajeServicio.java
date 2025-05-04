package vuelos.example.Vuelos.servicio;

import org.springframework.web.bind.annotation.PathVariable;
import vuelos.example.Vuelos.modelo.Pasaje;

import java.util.List;

public interface IPasajeServicio {
    //public List<Pasaje> listarPasajes();
    public Pasaje guardarPasaje(Pasaje pasaje);
    void eliminarPasaje(Pasaje pasaje);
    public Pasaje obtenerPasajePorId(int id);
    public List<Pasaje> listarPasajePorVuelo(Integer idVuelo);

}
