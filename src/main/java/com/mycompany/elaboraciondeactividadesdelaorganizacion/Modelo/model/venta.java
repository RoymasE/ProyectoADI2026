package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model;

public class venta {

    private int idVenta;
    private String idCliente;
    private String idProducto;
    private double valorAPagar;
    private String fechaVenta;
    private int estado;

    public venta() {
    }

    public venta(int idVenta, String idCliente, String idProducto, double valorAPagar, String fechaVenta, int estado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.valorAPagar = valorAPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
