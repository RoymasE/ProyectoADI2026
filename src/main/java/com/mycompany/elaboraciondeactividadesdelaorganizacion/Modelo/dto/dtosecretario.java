package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.secretario;

public class dtosecretario implements dtogeneral<secretario> {

    public dtosecretario() {
    }

    private secretario o;

    public dtosecretario(secretario o) {
        this.o = o;
    }

    @Override
    public secretario getC() {
        return o;
    }

    @Override
    public void setC(secretario o) {
        this.o = o;
    }

}
