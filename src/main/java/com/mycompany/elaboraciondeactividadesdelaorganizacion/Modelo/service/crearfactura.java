/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rfactura;

/**
 *
 * @author x
 */
public class crearfactura implements crearinterface<dtofactura>{
    rfactura rf = new rfactura();

    @Override
    public String regusitrar(dtofactura c) {
   rf.creardato(c);
   return "Se creo la factura";
    }
    
}
