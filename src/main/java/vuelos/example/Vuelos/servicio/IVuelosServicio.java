package vuelos.example.Vuelos.servicio;

import vuelos.example.Vuelos.modelo.Vuelo;
import vuelos.example.Vuelos.modelo.VueloDTO;

import java.util.List;

public interface IVuelosServicio {
    public List<Vuelo> listarVuelos();
    public Vuelo guardarVuelo(Vuelo vuelo);
    public void eliminarVuelo(Vuelo vuelo);
    public Vuelo obtenerVueloPorID(int id);
    //public Vuelo guardarVueloDesdeDTO(VueloDTO vueloDTO);

}
