package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Persona {
    @Id
    @EqualsAndHashCode.Include
    private String cedula;
    private String nombre;
    private String email;
    @ElementCollection
    private Map<String, String> numTelefono;
    @Enumerated(EnumType.STRING)
    private GeneroPersona generoPersona;



    public Persona(String cedula, String nombre, String email, String numTelefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;

    }


}

