package org.example.externo;

public class StripeUSA {

    public StripeUSA() {
        System.out.println("[STRIPE USA] Conexión segura con la pasarela internacional establecida.");
    }

    public boolean chargeInDollars(double amountUSD, String customerEmail, String merchantKey) {
        System.out.printf("[STRIPE USA] Charging US$%.2f to %s (merchant: %s)... APPROVED%n",
                amountUSD, customerEmail, merchantKey);
        return true;
    }
}
