/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.ircliente;

/**
 *
 * @author x
 */
public class eliminarcliente implements ircliente, eliminarinterface<dtocliente>{
    
    @Override
    public String eliminardato(dtocliente c){
    rc.eliminar(c);
    return "Se elimino el cliente";
    }
    
}
