package Clases;

import java.util.Date;

public class Pelicula {
    private int Id;
    private Date Lanzamiento;
    private String Nombre;
    private String Descripcion;

    public Pelicula() {}

    public Pelicula(int id, Date lanzamiento, String nombre, String descripcion) {
        Id = id;
        Lanzamiento = lanzamiento;
        Nombre = nombre;
        Descripcion = descripcion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getLanzamiento() {
        return Lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        Lanzamiento = lanzamiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  "Id=" + Id +"| Lanzamiento=" + Lanzamiento +"| Nombre='" + Nombre + "| Descripcion='" + Descripcion;
    }
}
