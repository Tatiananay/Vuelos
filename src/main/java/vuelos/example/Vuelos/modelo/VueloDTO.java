package vuelos.example.Vuelos.modelo;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VueloDTO {

    private String origen;
    private String destino;
    private LocalTime horaSalida;
    private Integer capacidadTotal;
    private String aerolinea;

    private Double precioVip;
    private Double precioEstandar;
    private Double precioEconomico;

    // Getters y setters
}

