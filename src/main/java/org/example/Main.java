package org.example;

import org.example.composite.ComponenteCatalogo;
import org.example.facade.ServicioExtra;
import org.example.facade.ShopMasterFacade;

public class Main {
    public static void main(String[] args) {

        ShopMasterFacade tienda = new ShopMasterFacade();

        System.out.println("=== CASO 1: Compra exitosa completa ===");
        ComponenteCatalogo kitLimpieza = tienda.crearCombo("Kit de Limpieza",
                tienda.crearProducto("Paño de microfibra", 25_000),
                tienda.crearProducto("Spray limpiador", 15_000)
        );
        ComponenteCatalogo comboGamer = tienda.crearCombo("Combo Setup Gamer",
                tienda.crearProducto("Monitor", 800_000),
                tienda.crearProducto("Teclado", 200_000),
                kitLimpieza // sub-combo dentro del combo principal
        );
        tienda.ejecutarCompraRapida("cliente_vip", comboGamer,
                ServicioExtra.GARANTIA_EXTENDIDA, ServicioExtra.EMPAQUE_REGALO);


        System.out.println("\n=== CASO 2: Rechazo por tope de dinero ===");
        ComponenteCatalogo servidor = tienda.crearProducto("Servidor Empresarial", 6_000_000);
        tienda.ejecutarCompraRapida("cliente_normal", servidor, ServicioExtra.MANEJO_FRAGIL);


        System.out.println("\n=== CASO 3: Rechazo por usuario reportado ===");
        ComponenteCatalogo mouse = tienda.crearProducto("Mouse", 150_000);
        tienda.ejecutarCompraRapida("BLOQUEADO", mouse);
    }
}
