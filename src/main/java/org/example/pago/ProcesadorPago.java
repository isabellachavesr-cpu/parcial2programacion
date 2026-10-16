package org.example.pago;

public interface ProcesadorPago {
    boolean cobrarEnPesos(String usuario, double montoCOP);
}
