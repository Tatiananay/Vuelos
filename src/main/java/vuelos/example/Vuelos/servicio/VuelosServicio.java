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

//    public Vuelo guardarVueloDesdeDTO(VueloDTO vueloDTO) {
//        Vuelo vuelo = new Vuelo();
//        vuelo.setOrigen(vueloDTO.getOrigen());
//        vuelo.setDestino(vueloDTO.getDestino());
//        vuelo.setHoraSalida(vueloDTO.getHoraSalida()); // Conversión
//        vuelo.setCapacidadTotal(vueloDTO.getCapacidadTotal());
//        vuelo.setAerolinea(vueloDTO.getAerolinea());
//
//        Vuelo vueloGuardado = vueloRepositorio.save(vuelo);
//
////        crearPasajesConPrecios(vueloGuardado,
////                vueloDTO.getPrecioVip(),
////                vueloDTO.getPrecioEstandar(),
////                vueloDTO.getPrecioEconomico()
//        );

//        return vueloGuardado;
//    }


    @Override
    public void eliminarVuelo(Vuelo vuelo) {
        vueloRepositorio.delete(vuelo);
    }

    @Override
    public Vuelo obtenerVueloPorID(int idVuelo) {
        return vueloRepositorio.findById(idVuelo).get();
    }


}
