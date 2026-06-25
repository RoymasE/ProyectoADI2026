/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rcliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.ircliente;

/**
 *
 * @author x
 */
public class actualizarcliente implements actualizarinterface<dtocliente>, ircliente{
 
    
    @Override
    public String actualizardato(dtocliente c){
    rc.actualizar(c);
    return "Se actualizo el cliente";
    }
    
    
}
