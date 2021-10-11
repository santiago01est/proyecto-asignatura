package co.edu.uniquindio.proyecto.test.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
@ToString
public class Persona implements Serializable {
    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false, length = 100)
    private String nombre;
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroPersona generoPersona;


}
