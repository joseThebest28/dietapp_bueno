package com.example.Dietapp.extras;

public class Ficha {
    private int imagen;
    private String nombre;
    private String descripcion;

    public Ficha() {

    }

    public Ficha(int imagen, String nombre, String descripcionReto) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcionReto;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getReto() {
        return descripcion;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setReto(String descripcionReto) {
        this.descripcion = descripcionReto;
    }
}

