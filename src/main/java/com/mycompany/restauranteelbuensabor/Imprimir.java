package com.mycompany.restauranteelbuensabor;
// Clase encargada únicamente de mostrar información en consola (SRP)
public class Imprimir {

    private static final String SEPARADOR = "==============================";
    private static final String LINEA = "-------------------------------";
    private static final String FORMATO_ITEM = "%-20s x%-6d $%,.0f%n";

    public static void mostrarCarta() {
        System.out.println(SEPARADOR);
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(LINEA);
        for (int i = 0; i < Datos.nombres.length; i++) {
            System.out.printf("%d. %-22s $%,.0f%n",
                    (i + 1),
                    Datos.nombres[i],
                    Datos.precios[i]);
        }
        System.out.println(SEPARADOR);
    }

    public static void mostrarPedido() {
        System.out.println(LINEA);
        System.out.println("--- PEDIDO ACTUAL ---");
        System.out.println(LINEA);
        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                double subtotalProducto = Datos.precios[i] * Datos.cantidades[i];
                System.out.printf(FORMATO_ITEM,
                        Datos.nombres[i],
                        Datos.cantidades[i],
                        subtotalProducto);
            }
        }
        System.out.println(LINEA);
        ResultadosFactura resultado = Proceso.calcularFactura();
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", resultado.subtotal);
        System.out.println(SEPARADOR);
    }

    public static void imprimirFacturaCompleta() {
        ResultadosFactura resultado = Proceso.calcularFactura();
        imprimirEncabezado("FACTURA No. " + String.format("%03d", Datos.numeroFactura));
        imprimirDetalleProductos();
        imprimirTotales(resultado);
        System.out.println("Gracias por su visita!");
        System.out.println(SEPARADOR);
        Datos.numeroFactura++;
        Datos.estadoMesa = 0;
        Datos.total = resultado.total;
    }

    public static void imprimirFacturaResumen() {
        ResultadosFactura resultado = Proceso.calcularFactura();
        imprimirEncabezado("FACTURA No. " +
                String.format("%03d", Datos.numeroFactura) + " (RESUMEN)");
        imprimirTotales(resultado);
        Datos.numeroFactura++;
        Datos.estadoMesa = 0;
        Datos.total = resultado.total;
    }

    private static void imprimirEncabezado(String titulo) {
        System.out.println(SEPARADOR);
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION_RESTAURANTE);
        System.out.println("    NIT: " + Datos.NIT_RESTAURANTE);
        System.out.println(SEPARADOR);
        System.out.println(titulo);
        System.out.println(LINEA);
    }

    private static void imprimirDetalleProductos() {
        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                double subtotalProducto = Datos.precios[i] * Datos.cantidades[i];
                System.out.printf(FORMATO_ITEM,
                        Datos.nombres[i],
                        Datos.cantidades[i],
                        subtotalProducto);
            }
        }
        System.out.println(LINEA);
    }

    private static void imprimirTotales(ResultadosFactura r) {
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", r.subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", r.iva);
        if (r.propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", r.propina);
        }
        System.out.println(LINEA);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", r.total);
        System.out.println(SEPARADOR);
    }
}