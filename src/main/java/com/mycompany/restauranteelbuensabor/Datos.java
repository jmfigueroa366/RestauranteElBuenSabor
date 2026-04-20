package com.mycompany.restauranteelbuensabor;

// Clase que almacena los datos del restaurante y el estado actual del pedido
public class Datos {

    // Constantes del restaurante
    public static final String NOMBRE_RESTAURANTE = "El Buen Sabor";
    public static final String DIRECCION_RESTAURANTE = "Calle 15 #8-32, Valledupar";
    public static final String NIT_RESTAURANTE = "900.123.456-7";

    // Carta del restaurante (solo lectura)
    public static final String[] nombres = {
        "Bandeja Paisa",
        "Sancocho de Gallina",
        "Arepa con Huevo",
        "Jugo Natural",
        "Gaseosa",
        "Cerveza Poker",
        "Agua Panela",
        "Arroz con Pollo"
    };

    public static final double[] precios = {
        32000, 28000, 8000, 7000, 4500, 6000, 3500, 25000
    };

    // Estado del pedido actual (se resetea entre pedidos)
    public static int[] cantidades = {0, 0, 0, 0, 0, 0, 0, 0};

    // Estado de la mesa y facturación
    public static int numeroMesa = 0;
    public static int estadoMesa = 0;
    public static double total = 0;
    public static int numeroFactura = 1;

    // Reinicia las cantidades del pedido actual
    public static void reiniciarPedido() {
        for (int i = 0; i < cantidades.length; i++) {
            cantidades[i] = 0;
        }
        total = 0;
    }
}