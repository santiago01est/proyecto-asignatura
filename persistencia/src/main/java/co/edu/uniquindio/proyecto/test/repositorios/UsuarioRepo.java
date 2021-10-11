package co.edu.uniquindio.proyecto.test.repositorios;

import co.edu.uniquindio.proyecto.test.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {
}
