package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.reguistro;

public class dtoreguistro implements dtogeneral<reguistro> {

    public dtoreguistro() {
    }

    private reguistro o;

    public dtoreguistro(reguistro o) {
        this.o = o;
    }

    @Override
    public reguistro getC() {
        return o;
    }

    @Override
    public void setC(reguistro o) {
        this.o = o;
    }

}
