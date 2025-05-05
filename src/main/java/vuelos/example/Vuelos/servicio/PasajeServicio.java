package vuelos.example.Vuelos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuelos.example.Vuelos.modelo.Pasaje;
import vuelos.example.Vuelos.repositorio.PasajeRepositorio;
import vuelos.example.Vuelos.repositorio.ReservaRepositorio;

import java.util.List;

@Service
public class PasajeServicio implements IPasajeServicio {
    @Autowired
    private PasajeRepositorio pasajeRepositorio;

    @Override
    public Pasaje guardarPasaje(Pasaje pasaje) {
        return pasajeRepositorio.save(pasaje);
    }

    @Override
    public void eliminarPasaje(Pasaje pasaje) {

    }

    @Override
    public Pasaje obtenerPasajePorId(int id) {
        return null;
    }

//    @Override
//    public List<Pasaje> listarPasajePorVuelo(Integer idVuelo) {
//        return pasajeRepositorio.findById_Vuelo(idVuelo);
//    }
}
