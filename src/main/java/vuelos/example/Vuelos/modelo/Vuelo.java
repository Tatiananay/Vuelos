package vuelos.example.Vuelos.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVuelo;
    private String origen;
    private String destino;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaSalida;
    private String capacidad;
    private String aerolinea;
}
