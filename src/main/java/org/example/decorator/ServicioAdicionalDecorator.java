package org.example.decorator;

public abstract class ServicioAdicionalDecorator implements Pedido {

    protected final Pedido pedidoEnvuelto;

    protected ServicioAdicionalDecorator(Pedido pedidoEnvuelto) {
        this.pedidoEnvuelto = pedidoEnvuelto;
    }

    @Override
    public double calcularCosto() {
        return pedidoEnvuelto.calcularCosto();
    }

    @Override
    public String getDescripcion() {
        return pedidoEnvuelto.getDescripcion();
    }
}
