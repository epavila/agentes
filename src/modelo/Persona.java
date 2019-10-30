package modelo;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private String id;
    private String direccion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String id, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.direccion = direccion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
