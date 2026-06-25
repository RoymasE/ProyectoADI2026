package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.producto;

public class dtoproducto implements dtogeneral<producto> {

    public dtoproducto() {
    }

    private producto o;

    public dtoproducto(producto o) {
        this.o = o;
    }

    @Override
    public producto getC() {
        return o;
    }

    @Override
    public void setC(producto o) {
        this.o = o;
    }

}
