package co.edu.uniquindio.proyecto.test.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Libro implements Serializable {
   @Id
   @EqualsAndHashCode.Include
   @Column(length = 50)
   private String isbn;
   @Column(nullable = false, length = 100)
   private String nombre;

   @Positive
   @Column(nullable = false)
   private Integer unidades;
   @Positive
   @Column(nullable = false)
   private Integer anio;
   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private GeneroLibro genero;
   @ManyToMany(mappedBy = "libros")
   private List<Prestamo> prestamos;

   @ManyToMany
   private List<Autor> autores;

   public Libro(String isbn, String nombre, Integer unidades, Integer anio){
       this.isbn=isbn;
       this.nombre=nombre;
       this.unidades=unidades;
       this.anio=anio;
   }

}
