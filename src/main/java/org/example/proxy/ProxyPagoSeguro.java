package org.example.proxy;

import org.example.adapter.StripeUSAAdapter;
import org.example.externo.StripeUSA;
import org.example.pago.ProcesadorPago;
import org.example.util.Moneda;

public class ProxyPagoSeguro implements ProcesadorPago {

    private static final double MONTO_MAXIMO = 5_000_000;
    private static final String USUARIO_BLOQUEADO = "BLOQUEADO";

    private ProcesadorPago procesadorReal;

    @Override
    public boolean cobrarEnPesos(String usuario, double montoCOP) {
        System.out.println("[PROXY SEGURIDAD] Verificando cobro de " + Moneda.cop(montoCOP) + " para '" + usuario + "'...");


        if (USUARIO_BLOQUEADO.equals(usuario)) {
            System.out.println("[ALERTA DE SEGURIDAD] Usuario reportado como BLOQUEADO. Transacción RECHAZADA.");
            return false;
        }

        if (montoCOP > MONTO_MAXIMO) {
            System.out.println("[RECHAZADO] El monto " + Moneda.cop(montoCOP) + " supera el tope de "
                    + Moneda.cop(MONTO_MAXIMO) + ". Transacción RECHAZADA.");
            return false;
        }

        if (procesadorReal == null) {
            System.out.println("[PROXY SEGURIDAD] Datos válidos. Conectando con el procesador real por primera vez...");
            procesadorReal = new StripeUSAAdapter(new StripeUSA());
        }

        boolean aprobado = procesadorReal.cobrarEnPesos(usuario, montoCOP);

        if (aprobado) {
            System.out.println("[AUDITORÍA: Transacción aprobada para " + usuario + " por " + Moneda.cop(montoCOP) + "]");
        }
        return aprobado;
    }
}
