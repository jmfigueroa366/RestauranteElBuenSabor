package com.mycompany.restauranteelbuensabor;
//Clase encargada unicamente de moestrar informacion en consola(srp)
public class Imprimir {
    //contantes para evitar repetir texto(evita harcodeo)
    private static final String SEPARADOR="==============================";
    private static final String LINEA="-------------------------------";    
    //muestrame la carta del restaurante
public static void mostrarCarta(){
    //Encabezado visual
System.out.println(SEPARADOR);
System.out.println("    RESTAURANTE EL BUEN SABOR");
System.out.println("    --- NUESTRA CARTA ---");
System.out.println(LINEA);
//Recorre todos lo productos
for(int i=0;i<Datos.nom.length;i++){
    //imprime numero,nombre y precio con formato
    System.out.printf("%d. %-22s $%,.0f%n ",
            (i+1),//numero del producto
            Datos.nom[i],//nombre
            Datos.p[i]);//precio
}
//cierre visual
System.out.println(SEPARADOR);
}
//muestra el pedido actual del cliente
public static void mostrarPedido(){
 System.out.println("---pedido actual---");
 //recorre productos
 for(int i=0;i<Datos.nom.length;i++){
     //solo imprime los productos que tengan cantidad > 0
     if(Datos.cant[i]>0){
         //calcula subtotal por productos
         double SubtotalProducto = Datos.p[i]*Datos.cant[i];
     //imprime producto con cantidad y subtotal
     System.out.printf("%-20s x%-6d $%,.0f%n,",
             Datos.nom[i],
             Datos.cant[i],
             SubtotalProducto);
     }
System.out.println(LINEA);
//muestra subtotales usando logica separada(proceso)
System.out.printf("%-27 $%,0f%n",
        "subtotal",
Proceso.calcularSubtotal());
//imprime factura completa usando logia separada(proceso)
public static void imprimirFacturaCompleta(){
    //obtiene resultado y calculado(separacion de responsabilidades)
    ResultadoFactura resultado =Proceso.calcularFactura();
    //imprime encabezado
    imprimirEncabezado("factura NO."+ String.format("%03d",Datos.nf));
    //imprimer productos
    imprimirDetalleProductos();
    //imprime totales
    imprimirTotales(resultado);
    //mensaje final
    System.out.println("gracias por su visita!");
    System.out.println("el buen sabor - valledupar");
    System.out.println(SEPARADOR);
    //Actualiza estado del sistema(factura,estado,total)
    Datos.nf++;
    Datos.est=0;
    Datos=resultado.total;
    //imprime solo resumen(sin detalle de productos)
    public static void imprimirFacturaResumen(){
        // Calcula factura
        ResultadoFactura resultado = Proceso.calcularFactura();
        // Encabezado con etiqueta RESUMEN
        imprimirEncabezado("FACTURA No. " +
                String.format("%03d", Datos.nf) + " (RESUMEN)");
        // Solo totales
        imprimirTotales(resultado);
        // 🔹 Método privado: imprime encabezado de factura
    private static void imprimirEncabezado(String titulo) {
        System.out.println(SEPARADOR);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(SEPARADOR);
        // Título dinámico
        System.out.println(titulo);
        System.out.println(LINEA);
    }
     //  Método privado: imprime productos del pedido
    private static void imprimirDetalleProductos() {

        for (int i = 0; i < Datos.nom.length; i++) {
            if (Datos.cant[i] > 0) {
                double subtotalProducto = Datos.p[i] * Datos.cant[i];
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nom[i],
                        Datos.cant[i],
                        subtotalProducto);
            }
        }
        System.out.println(LINEA);
    // 🔹 Método privado: imprime subtotal, IVA, propina y total
    private static void imprimirTotales(ResultadoFactura r){
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", r.subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", r.iva);
        // Solo muestra propina si existe
        if (r.propina > 0) {
            System.out.printf("%-27s $%,.0f%n",
                    "Propina (10%):",
                    r.propina);
        }
        System.out.println(LINEA);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", r.total);
        System.out.println(SEPARADOR);
    }
}