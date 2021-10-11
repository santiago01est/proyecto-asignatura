package co.edu.uniquindio.proyecto.test.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Autor extends Persona implements Serializable {

    @Column(nullable = false, precision = 4)
    private Integer anioNacimineto;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;





}
