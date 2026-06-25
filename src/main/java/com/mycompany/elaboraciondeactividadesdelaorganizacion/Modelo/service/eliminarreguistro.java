/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoreguistro;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irreguistro;

/**
 *
 * @author x
 */
public class eliminarreguistro implements eliminarinterface<dtoreguistro>, irreguistro {

    @Override
    public String eliminardato(dtoreguistro c) {
   rr.eliminar(c);
   return "Se elimino el reguistro";
    }
    
}
