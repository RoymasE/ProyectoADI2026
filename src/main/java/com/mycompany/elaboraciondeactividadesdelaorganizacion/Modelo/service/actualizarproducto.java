/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irproducto;

/**
 *
 * @author x
 */
public class actualizarproducto implements actualizarinterface<dtoproducto>, irproducto {

    @Override
    public String actualizardato(dtoproducto c) {
  rp.actualizar(c);
  return "Se actualizo el producto";
    }
    
}
