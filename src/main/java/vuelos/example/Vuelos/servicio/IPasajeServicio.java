package vuelos.example.Vuelos.servicio;

import vuelos.example.Vuelos.modelo.Pasaje;

import java.util.List;

public interface IPasajeServicio {
    public List<Pasaje> listarPasajes();
    public Pasaje guardarPasaje(Pasaje pasaje);
    void eliminarPasaje(Pasaje pasaje);
    public Pasaje obtenerPasajePorId(int id);

}
