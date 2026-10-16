package org.example.facade;

import org.example.composite.Combo;
import org.example.composite.ComponenteCatalogo;
import org.example.composite.ProductoIndividual;
import org.example.decorator.EmpaqueRegalo;
import org.example.decorator.GarantiaExtendida;
import org.example.decorator.ManejoFragil;
import org.example.decorator.Pedido;
import org.example.decorator.PedidoBase;
import org.example.pago.ProcesadorPago;
import org.example.proxy.ProxyPagoSeguro;
import org.example.util.Moneda;

public class ShopMasterFacade {


    private final ProcesadorPago procesadorPago = new ProxyPagoSeguro();

    public ComponenteCatalogo crearProducto(String nombre, double precio) {
        return new ProductoIndividual(nombre, precio);
    }

    public ComponenteCatalogo crearCombo(String nombre, ComponenteCatalogo... componentes) {
        return new Combo(nombre, componentes);
    }

    public boolean ejecutarCompraRapida(String usuario, ComponenteCatalogo carrito, ServicioExtra... extras) {

        System.out.println("Desglose de productos:");
        carrito.mostrarDesglose(1);


        Pedido pedido = new PedidoBase(carrito);
        System.out.println("Subtotal productos: " + Moneda.cop(pedido.calcularCosto()));
        for (ServicioExtra extra : extras) {
            pedido = aplicarExtra(pedido, extra);
            System.out.println("  Después de " + extra + ": " + Moneda.cop(pedido.calcularCosto()));
        }
        double total = pedido.calcularCosto();
        System.out.println(pedido.getDescripcion());
        System.out.println("TOTAL A PAGAR: " + Moneda.cop(total));


        boolean aprobado = procesadorPago.cobrarEnPesos(usuario, total);
        System.out.println(aprobado ? ">> COMPRA EXITOSA" : ">> COMPRA NO REALIZADA");
        return aprobado;
    }

    private Pedido aplicarExtra(Pedido pedido, ServicioExtra extra) {
        return switch (extra) {
            case GARANTIA_EXTENDIDA -> new GarantiaExtendida(pedido);
            case EMPAQUE_REGALO -> new EmpaqueRegalo(pedido);
            case MANEJO_FRAGIL -> new ManejoFragil(pedido);
        };
    }
}
