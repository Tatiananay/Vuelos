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

public class Usuario {

    public enum Rol{
        ADMINISTRADOR,
        USER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

}
