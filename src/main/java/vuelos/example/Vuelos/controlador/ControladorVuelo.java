package vuelos.example.Vuelos.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vuelos.example.Vuelos.excepcion.RecursoNoEncontradoExcepcion;
import vuelos.example.Vuelos.modelo.Vuelo;
import vuelos.example.Vuelos.modelo.VueloDTO;
import vuelos.example.Vuelos.servicio.IVuelosServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vuelo-app")
@CrossOrigin("*")
public class ControladorVuelo {
    private static final Logger logger= LoggerFactory.getLogger(ControladorUsuario.class);
    @Autowired
    private IVuelosServicio vuelosServicio;

    @GetMapping("/vuelos")
    public List<Vuelo> obtenerVuelos() {
        var vuelos = vuelosServicio.listarVuelos();
        vuelos.forEach(vuelo -> {logger.info(vuelo.toString());});
        return vuelos;
    }

//    @PostMapping("/vuelos")
//    public Vuelo guardarVuelo(@RequestBody Vuelo vuelo) {
//        logger.info(vuelo.toString());
//        return vuelosServicio.guardarVuelo(vuelo);
//    }

    @GetMapping("/vuelos/{id}")
    public ResponseEntity<Vuelo> obtenerVueloPorId(@PathVariable Integer id) {
        Vuelo vuelo = vuelosServicio.obtenerVueloPorID(id);
        if (vuelo == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id" + id);
        }
        return ResponseEntity.ok(vuelo);
    }

    @PutMapping("/vuelos/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Integer id, @RequestBody Vuelo vueloRecibido) {
        Vuelo vuelo = vuelosServicio.obtenerVueloPorID(id);
        if (vuelo == null) {
            throw new RecursoNoEncontradoExcepcion("Id: " + id + " no existe");
        }
        vuelo.setOrigen(vueloRecibido.getOrigen());
        vuelo.setDestino(vueloRecibido.getDestino());
        vuelo.setHoraSalida(vueloRecibido.getHoraSalida());
        vuelo.setCapacidadTotal(vueloRecibido.getCapacidadTotal());
        vuelo.setAerolinea(vueloRecibido.getAerolinea());
        vuelosServicio.guardarVuelo(vuelo);
        return ResponseEntity.ok(vuelo);
    }

//    @PostMapping("/vuelos")
//    public Vuelo guardarVuelo(@RequestBody VueloDTO vueloDTO) {
//        logger.info("Guardando vuelo con DTO");
//        return vuelosServicio.guardarVueloDesdeDTO(vueloDTO);
//    }

    @DeleteMapping("/vuelos/{id}")

    public ResponseEntity<Map> eliminarVuelo(@PathVariable Integer id) {
        Vuelo vuelo = vuelosServicio.obtenerVueloPorID(id);
        if (vuelo == null) {
            throw new RecursoNoEncontradoExcepcion("Id: " + id + " no existe");
        }
        vuelosServicio.eliminarVuelo(vuelo);

        Map<String,Boolean> map = new HashMap<>();
        map.put("eliminado" , Boolean.TRUE);
        return ResponseEntity.ok(map);
    }




}
