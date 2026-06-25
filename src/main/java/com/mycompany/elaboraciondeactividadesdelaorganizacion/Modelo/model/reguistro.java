/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model;

/**
 *
 * @author x
 */
public class reguistro {

    private String idRegistro;
    private String idSecretario;
    private String idCliente;

    public reguistro() {
    }

    public reguistro(String idRegistro, String idSecretario, String idCliente) {
        this.idRegistro = idRegistro;
        this.idSecretario = idSecretario;
        this.idCliente = idCliente;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(String idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

}
