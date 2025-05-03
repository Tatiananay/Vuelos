package vuelos.example.Vuelos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuelos.example.Vuelos.modelo.Vuelo;
import vuelos.example.Vuelos.repositorio.VueloRepositorio;

import java.util.List;

@Service
public class VuelosServicio implements IVuelosServicio{
    @Autowired
    private VueloRepositorio vueloRepositorio;

    @Override
    public List<Vuelo> listarVuelos() {
        return vueloRepositorio.findAll();
    }

    @Override
    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepositorio.save(vuelo);
    }

    @Override
    public void eliminarVuelo(Vuelo vuelo) {
        vueloRepositorio.delete(vuelo);
    }

    @Override
    public Vuelo obtenerVueloPorID(int id) {
        return vueloRepositorio.findById(id).get();
    }
}
