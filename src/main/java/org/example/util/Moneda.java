package org.example.util;

import java.util.Locale;

public class Moneda {

    private static final Locale COLOMBIA = Locale.of("es", "CO");

    private Moneda() {
    }

    public static String cop(double valor) {
        return String.format(COLOMBIA, "$%,.0f COP", valor);
    }

    public static String usd(double valor) {
        return String.format(Locale.US, "US$%,.2f", valor);
    }
}
