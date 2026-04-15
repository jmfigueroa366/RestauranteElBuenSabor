package com.mycompany.restauranteelbuensabor;
//clase encargada solo de la logica de negocios(Calculos)
public class Proceso {
    // contantes (evita numero magicos)
    private static final double IVA=0.19;
    private static final double DESCUENTO=0.09;
    private static final double PROPINA=0.10;
    private static final double LIMITE_PROPINA=50000;
   //CONTANTE (EVITA NUMERO MAGICOS)
public static double calcularSubtotal(){ 
double subtotal=0;
for(int i=0;i<Datos.nom.length;i++){
subtotal+=Datos.p[i]*Datos.cant[i];
}
return subtotal;
}
//metodo principal que usa imprimir(no se rompe nada)
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
    // 🔹 Cuenta cuántos productos diferentes hay en el pedido
    private static int contarProductos(){
        int contador = 0;
        for (int i = 0; i < Datos.nom.length; i++) {
            if (Datos.cant[i] > 0) {
                contador++;
            }
        }
        return contador;
    }
    // 🔹 Aplica descuento si hay más de 3 productos
    private static double aplicarDescuento(double subtotal, int cantidadProductos) {

        if (cantidadProductos > 3) {
            return subtotal - (subtotal * DESCUENTO);
        }

        return subtotal;
    }
     // 🔹 Calcula el IVA
    private static double calcularIVA(double subtotal) {
        return subtotal * IVA;
    }
    // 🔹 Calcula propina si supera el límite
    private static double calcularPropina(double subtotal, double totalParcial) {

        if (subtotal > LIMITE_PROPINA) {
            return totalParcial * PROPINA;
        }

        return 0;
    }
}

