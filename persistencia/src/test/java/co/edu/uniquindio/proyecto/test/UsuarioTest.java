package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.test.entidades.Ciudad;
import co.edu.uniquindio.proyecto.test.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.test.entidades.Usuario;
import co.edu.uniquindio.proyecto.test.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.test.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest(){

        Ciudad ciudad= ciudadRepo.findById(1).orElse(null);
        Map<String, String> telefono= new HashMap<>();
        telefono.put("casa","1717171");
        telefono.put("celular","9898589");

        Usuario usuario=new Usuario("123","Pepito",LocalDate.now(),GeneroPersona.MASCULINO,"pepe@gmail.com", telefono,ciudad);
        Usuario usuarioGuardado= usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);

    }
    @Test
    @Sql("classpath:usuarios.sql")
    public void eliminarTest(){

        usuarioRepo.deleteById("123");

        Usuario usuarioBuscado= usuarioRepo.findById("123").orElse(null);

        Assertions.assertNull(usuarioBuscado);
    }
    @Test
    @Sql("classpath:usuarios.sql")
    public void actualizarTest(){
        Usuario guardado= usuarioRepo.findById("124").orElse(null);
       guardado.setEmail("maria_correonuevo@gmail.com");
       usuarioRepo.save(guardado);
        Usuario usuarioBuscado= usuarioRepo.findById("124").orElse(null);

        Assertions.assertEquals("maria_correonuevo@gmail.com",usuarioBuscado.getEmail());
    }
    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest(){

        List<Usuario> usuarios= usuarioRepo.findAll();
        usuarios.forEach(u -> System.out.println(u) );
    }

}
