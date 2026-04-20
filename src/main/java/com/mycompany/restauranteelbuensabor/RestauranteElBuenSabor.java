package com.mycompany.restauranteelbuensabor;
import java.util.Scanner;
// Clase principal — solo coordina el menú y delega a las demás clases (SRP)
public class RestauranteElBuenSabor {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarEncabezado();
        boolean activo = true;
        while (activo) {
            mostrarMenu();
            int opcion = sc.nextInt();
            if (opcion == 0) {
                activo = false;
                System.out.println("Hasta luego!");
            } else {
                procesarOpcion(opcion);
            }
        }
        sc.close();
    }
    private static void mostrarEncabezado() {
        System.out.println("========================================");
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION_RESTAURANTE);
        System.out.println("    NIT: " + Datos.NIT_RESTAURANTE);
        System.out.println("========================================");
    }
    private static void mostrarMenu() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                Imprimir.mostrarCarta();
                break;
            case 2:
                manejarAgregarProducto();
                break;
            case 3:
                manejarVerPedido();
                break;
            case 4:
                manejarGenerarFactura();
                break;
            case 5:
                manejarNuevaMesa();
                break;
            default:
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
        }
        System.out.println();
    }

    private static void manejarAgregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + Datos.nombres.length + "): ");
        int numeroProducto = sc.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        if (numeroProducto <= 0 || numeroProducto > Datos.nombres.length) {
            System.out.println("Producto no existe. La carta tiene "
                    + Datos.nombres.length + " productos.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
            return;
        }
        if (Datos.estadoMesa == 0) {
            registrarMesa();
        }
        Datos.cantidades[numeroProducto - 1] += cantidad;
        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + Datos.nombres[numeroProducto - 1] + " x" + cantidad);
    }
    private static void registrarMesa() {
        System.out.print("Ingrese numero de mesa: ");
        int mesa = sc.nextInt();
        if (mesa > 0) {
            Datos.numeroMesa = mesa;
        } else {
            System.out.println("Numero invalido. Se asigna mesa 1.");
            Datos.numeroMesa = 1;
        }
        Datos.estadoMesa = 1;
    }
    private static void manejarVerPedido() {
        if (Utilidades.hayProductosEnPedido()) {
            Imprimir.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
        }
    }
    private static void manejarGenerarFactura() {
        if (Utilidades.hayProductosEnPedido()) {
            Imprimir.imprimirFacturaCompleta();
        } else {
            System.out.println("No se puede generar factura.");
            System.out.println("No hay productos en el pedido.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
        }
    }
    private static void manejarNuevaMesa() {
        Datos.reiniciarPedido();
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
    }
}