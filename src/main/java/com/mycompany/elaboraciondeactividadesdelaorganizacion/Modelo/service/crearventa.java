/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rventa;

/**
 *
 * @author x
 */
public class crearventa implements crearinterface<dtoventa> {

    rventa rv = new rventa();

    @Override
    public String regusitrar(dtoventa c) {
        rv.creardato(c);
        return "Se creo la venta";
    }

}
