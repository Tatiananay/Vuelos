package vuelos.example.Vuelos.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPasaje;
    //@ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Integer idVuelo;

    private Double precio;
    private Integer cantidadDisponible;
    public enum tipoPasaaje{
        VIP,
        ESTANDAR,
        ECONOMICO
    }
    @Enumerated(EnumType.STRING)
    private tipoPasaaje tipo; //vip, estandar, economico
}
