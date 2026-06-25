/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model;

/**
 *
 * @author x
 */
public class factura {

    private int idFactura;
    private int idVenta;
    private int cantidad;
    private double subTotal;
    private String fecha;
    private String correo;
    private double iva;
    private double irpf;
    private String idSecretario;

    public factura() {
    }

    public factura(int idFactura, int idVenta, int cantidad, double subTotal, String fecha, String correo, double iva, double irpf, String idSecretario) {
        this.idFactura = idFactura;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.fecha = fecha;
        this.correo = correo;
        this.iva = iva;
        this.irpf = irpf;
        this.idSecretario = idSecretario;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

    public String getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(String idSecretario) {
        this.idSecretario = idSecretario;
    }

}
