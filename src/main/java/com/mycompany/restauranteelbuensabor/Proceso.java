package com.mycompany.restauranteelbuensabor;
// Clase encargada solo de la lógica de negocio (cálculos)
public class Proceso {
    private static final double TASA_IVA = 0.19;
    private static final double TASA_DESCUENTO = 0.05;
    private static final double TASA_PROPINA = 0.10;
    private static final double UMBRAL_PROPINA = 50000;
    private static final int MIN_ITEMS_DESCUENTO = 3;
    public static ResultadosFactura calcularFactura() {
        double subtotal = calcularSubtotal();
        int cantidadProductos = contarProductos();
        double subtotalConDescuento = aplicarDescuento(subtotal, cantidadProductos);
        double iva = calcularIVA(subtotalConDescuento);
        double totalParcial = subtotalConDescuento + iva;
        double propina = calcularPropina(subtotalConDescuento, totalParcial);
        double total = totalParcial + propina;
        return new ResultadosFactura(subtotalConDescuento, iva, propina, total);
    }
    private static double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < Datos.nombres.length; i++) {
            subtotal += Datos.precios[i] * Datos.cantidades[i];
        }
        return subtotal;
    }
    private static int contarProductos() {
        int contador = 0;
        for (int i = 0; i < Datos.cantidades.length; i++) {
            if (Datos.cantidades[i] > 0) {
                contador++;
            }
        }
        return contador;
    }
    private static double aplicarDescuento(double subtotal, int cantidadProductos) {
        if (cantidadProductos > MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * TASA_DESCUENTO);
        }
        return subtotal;
    }
    private static double calcularIVA(double subtotal) {
        return subtotal * TASA_IVA;
    }
    private static double calcularPropina(double subtotal, double totalParcial) {
        if (subtotal > UMBRAL_PROPINA) {
            return totalParcial * TASA_PROPINA;
        }
        return 0;
    }
}