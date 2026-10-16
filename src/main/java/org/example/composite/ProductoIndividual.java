package org.example.composite;

import org.example.util.Moneda;

public class ProductoIndividual implements ComponenteCatalogo {

    private final String nombre;
    private final double precio;

    public ProductoIndividual(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }

    @Override
    public void mostrarDesglose(int nivel) {
        System.out.println("   ".repeat(nivel) + "- " + nombre + ": " + Moneda.cop(precio));
    }
}

