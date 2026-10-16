package org.example.adapter;

import org.example.externo.StripeUSA;
import org.example.pago.ProcesadorPago;
import org.example.util.Moneda;


public class StripeUSAAdapter implements ProcesadorPago {

    private static final double TASA_COP_POR_USD = 4_000;
    private static final String MERCHANT_KEY = "SHOPMASTER-MK-2026";
    private static final String DOMINIO_CORREO = "@shopmaster.com";

    private final StripeUSA stripe;

    public StripeUSAAdapter(StripeUSA stripe) {
        this.stripe = stripe;
    }

    @Override
    public boolean cobrarEnPesos(String usuario, double montoCOP) {
     
        double montoUSD = montoCOP / TASA_COP_POR_USD;
        String email = usuario + DOMINIO_CORREO;
        System.out.println("[ADAPTER] Convirtiendo " + Moneda.cop(montoCOP) + " a " + Moneda.usd(montoUSD)
                + " (1 USD = $4.000 COP)");


        return stripe.chargeInDollars(montoUSD, email, MERCHANT_KEY);
    }
}