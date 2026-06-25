package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.venta;

public class dtoventa implements dtogeneral<venta> {

    public dtoventa() {
    }

    private venta o;

    public dtoventa(venta o) {
        this.o = o;
    }

    @Override
    public venta getC() {
        return o;
    }

    @Override
    public void setC(venta o) {
        this.o = o;
    }

}
