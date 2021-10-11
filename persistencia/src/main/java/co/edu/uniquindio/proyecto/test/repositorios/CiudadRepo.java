package co.edu.uniquindio.proyecto.test.repositorios;

import co.edu.uniquindio.proyecto.test.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {


}
