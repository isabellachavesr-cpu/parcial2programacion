package org.example.decorator;

public class EmpaqueRegalo extends ServicioAdicionalDecorator {

    private static final double VALOR = 15_000;

    public EmpaqueRegalo(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + VALOR;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Empaque de Regalo ($15.000)";
    }
}
