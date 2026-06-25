/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.cliente;

/**
 *
 * @author x
 */
public class dtocliente implements dtogeneral<cliente> {

    private cliente o;

    public dtocliente() {
    }

    public dtocliente(cliente o) {
        this.o = o;
    }

    @Override
    public cliente getC() {
        return o;
    }

    @Override
    public void setC(cliente o) {
        this.o = o;
    }

}
