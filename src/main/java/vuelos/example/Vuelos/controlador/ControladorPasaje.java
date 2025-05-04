package vuelos.example.Vuelos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vuelos.example.Vuelos.servicio.IPasajeServicio;
//import java.util.logging.Logger;

@RestController
@RequestMapping("vuelo-app")
@CrossOrigin("*")
public class ControladorPasaje {
    private static Logger log = LoggerFactory.getLogger(ControladorPasaje.class);
    @Autowired
    private IPasajeServicio pasajeServicio;

}
