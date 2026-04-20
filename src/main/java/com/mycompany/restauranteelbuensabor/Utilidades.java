package com.mycompany.restauranteelbuensabor;

// Clase con utilidades de validación del pedido
public class Utilidades {

    // Verifica si hay al menos un producto con cantidad mayor a cero
    public static boolean hayProductosEnPedido() {
        for (int i = 0; i < Datos.cantidades.length; i++) {
            if (Datos.cantidades[i] > 0) {
                return true;
            }
        }
        return false;
    }
}