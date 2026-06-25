package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.cliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.factura;

public class dtofactura implements dtogeneral<factura> {

    private factura o;

    public dtofactura() {
    }

    public dtofactura(factura o) {
        this.o = o;
    }

    @Override
    public factura getC() {
        return o;
    }

    @Override
    public void setC(factura o) {
        this.o = o;
    }

}
