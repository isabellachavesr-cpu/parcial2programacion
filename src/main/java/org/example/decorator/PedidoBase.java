package org.example.decorator;

import org.example.composite.ComponenteCatalogo;

public class PedidoBase implements Pedido {

    private final ComponenteCatalogo contenido;

    public PedidoBase(ComponenteCatalogo contenido) {
        this.contenido = contenido;
    }

    @Override
    public double calcularCosto() {
        return contenido.calcularPrecio();
    }

    @Override
    public String getDescripcion() {
        return "Pedido: " + contenido.getNombre();
    }
}
