package co.edu.uniquindio.proyecto.test.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(nullable = false, length = 80)
    private String nombre;
    //relacion inversa debe tener un mappeby
    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;


    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

}
