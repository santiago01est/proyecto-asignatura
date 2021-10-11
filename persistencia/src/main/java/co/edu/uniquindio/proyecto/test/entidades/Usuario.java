package co.edu.uniquindio.proyecto.test.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario  extends Persona{


    @Column(nullable = false, unique = true, length = 120)
    private String email;
    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> numTelefono;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;
    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Prestamo>prestamo;

    public Usuario(String codigo, String nombre, LocalDate fechaNacimiento, GeneroPersona generoPersona, String email, Map<String, String> numTelefono, Ciudad ciudad) {
        super(codigo, nombre, fechaNacimiento, generoPersona);
        this.email = email;
        this.numTelefono = numTelefono;
        this.ciudad=ciudad;
    }

}

