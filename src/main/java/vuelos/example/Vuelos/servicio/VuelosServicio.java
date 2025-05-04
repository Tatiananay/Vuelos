package vuelos.example.Vuelos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuelos.example.Vuelos.modelo.Pasaje;
import vuelos.example.Vuelos.modelo.Vuelo;
import vuelos.example.Vuelos.modelo.VueloDTO;
import vuelos.example.Vuelos.repositorio.PasajeRepositorio;
import vuelos.example.Vuelos.repositorio.VueloRepositorio;

import java.time.LocalTime;
import java.util.List;

@Service
public class VuelosServicio implements IVuelosServicio{
    @Autowired
    private VueloRepositorio vueloRepositorio;

    @Autowired
    private PasajeRepositorio pasajeRepositorio;

    @Override
    public List<Vuelo> listarVuelos() {
        return vueloRepositorio.findAll();
    }

    @Override
    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepositorio.save(vuelo);
    }

    public Vuelo guardarVueloDesdeDTO(VueloDTO vueloDTO) {
        Vuelo vuelo = new Vuelo();
        vuelo.setOrigen(vueloDTO.getOrigen());
        vuelo.setDestino(vueloDTO.getDestino());
        vuelo.setHoraSalida(vueloDTO.getHoraSalida()); // Conversión
        vuelo.setCapacidadTotal(vueloDTO.getCapacidadTotal());
        vuelo.setAerolinea(vueloDTO.getAerolinea());

        Vuelo vueloGuardado = vueloRepositorio.save(vuelo);

        crearPasajesConPrecios(vueloGuardado,
                vueloDTO.getPrecioVip(),
                vueloDTO.getPrecioEstandar(),
                vueloDTO.getPrecioEconomico()
        );

        return vueloGuardado;
    }

    private void crearPasajesConPrecios(Vuelo vuelo, Double precioVip, Double precioEst, Double precioEco) {
        int capacidad = vuelo.getCapacidadTotal();

        Pasaje vip = new Pasaje(null, vuelo, precioVip, capacidad * 10 / 100, Pasaje.tipoPasaaje.VIP);
        Pasaje est = new Pasaje(null, vuelo, precioEst, capacidad * 30 / 100, Pasaje.tipoPasaaje.ESTANDAR);
        Pasaje eco = new Pasaje(null, vuelo, precioEco, capacidad * 60 / 100, Pasaje.tipoPasaaje.ECONOMICO);

        pasajeRepositorio.saveAll(List.of(vip, est, eco));
    }


    @Override
    public void eliminarVuelo(Vuelo vuelo) {
        vueloRepositorio.delete(vuelo);
    }

    @Override
    public Vuelo obtenerVueloPorID(int idVuelo) {
        return vueloRepositorio.findById(idVuelo).get();
    }
}
