package org.example.composite;

import org.example.util.Moneda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combo implements ComponenteCatalogo {

    private final String nombre;
    private final List<ComponenteCatalogo> hijos = new ArrayList<>();

    public Combo(String nombre, ComponenteCatalogo... componentes) {
        this.nombre = nombre;
        hijos.addAll(Arrays.asList(componentes));
    }

    public void agregar(ComponenteCatalogo componente) {
        hijos.add(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularPrecio() {
        return hijos.stream().mapToDouble(ComponenteCatalogo::calcularPrecio).sum();
    }

    @Override
    public void mostrarDesglose(int nivel) {
        System.out.println("   ".repeat(nivel) + "+ [COMBO] " + nombre + ": " + Moneda.cop(calcularPrecio()));
        for (ComponenteCatalogo hijo : hijos) {
            hijo.mostrarDesglose(nivel + 1);
        }
    }
}
