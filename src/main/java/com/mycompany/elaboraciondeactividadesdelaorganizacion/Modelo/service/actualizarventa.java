/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irventa;

/**
 *
 * @author x
 */
public class actualizarventa implements actualizarinterface<dtoventa>, irventa {

    @Override
    public String actualizardato(dtoventa c) {
  rv.actualizar(c);
  return "Se actualizo la venta";
    }
    
}
