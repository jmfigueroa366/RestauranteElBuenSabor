package com.mycompany.restauranteelbuensabor;
// Clase que agrupa los resultados de la factura
public class ResultadosFactura {
    public double subtotal;
    public double iva;
    public double propina;
    public double total;
    public ResultadosFactura() {
    }
    public ResultadosFactura(double subtotal, double iva, double propina, double total) {
        this.subtotal = subtotal;
        this.iva = iva;
        this.propina = propina;
        this.total = total;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getIva() {
        return iva;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }
    public double getPropina() {
        return propina;
    }
    public void setPropina(double propina) {
        this.propina = propina;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
