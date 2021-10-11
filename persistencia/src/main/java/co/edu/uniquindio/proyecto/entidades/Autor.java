package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Objects;

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
