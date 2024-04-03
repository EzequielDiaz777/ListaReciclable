package com.softulp.listareciclable.modelo;

public class Inmueble {
    private String direccion;
    private double precio;

    private int foto;

    public Inmueble(String direccion, double precio, int foto) {
        this.direccion = direccion;
        this.precio = precio;
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
