package org.example.decorator;

public class ManejoFragil extends ServicioAdicionalDecorator {

    private static final double VALOR = 25_000;

    public ManejoFragil(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + VALOR;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Manejo Frágil ($25.000)";
    }
}
