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
public class eliminarproducto implements eliminarinterface<dtoproducto>, irproducto{

    @Override
    public String eliminardato(dtoproducto c) {
   rp.eliminar(c);
   return "Se elimino el producto";
    }
    
}
