package org.example.decorator;

public class GarantiaExtendida extends ServicioAdicionalDecorator {

    private static final double PORCENTAJE = 0.10;

    public GarantiaExtendida(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto);
    }

    @Override
    public double calcularCosto() {
        double costoActual = super.calcularCosto();
        return costoActual + costoActual * PORCENTAJE;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Garantía Extendida (10%)";
    }
}