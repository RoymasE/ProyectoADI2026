/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irfactura;

/**
 *
 * @author x
 */
public class actualizarfactura implements actualizarinterface<dtofactura>, irfactura{

    @Override
    public String actualizardato(dtofactura c) {
  rf.actualizar(c);
  return "Se actualizo la factura";
    }
    
}
