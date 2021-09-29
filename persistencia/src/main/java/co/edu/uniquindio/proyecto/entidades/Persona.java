package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Persona {
    @Id
    private String cedula;
    private String nombre;
    private String email;
    @ElementCollection
    private Map<String, String> numTelefono;
    @Enumerated(EnumType.STRING)
    private GeneroPersona generoPersona;

    public Persona(){
        super();
    }

    public Persona(String cedula, String nombre, String email, String numTelefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Map<String, String> numTelefono) {
        this.numTelefono = numTelefono;
    }

    public GeneroPersona getGenero() {
        return generoPersona;
    }

    public void setGenero(GeneroPersona generoPersona) {
        this.generoPersona = generoPersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return cedula != null ? cedula.equals(persona.cedula) : persona.cedula == null;
    }

    @Override
    public int hashCode() {
        return cedula != null ? cedula.hashCode() : 0;
    }
}

