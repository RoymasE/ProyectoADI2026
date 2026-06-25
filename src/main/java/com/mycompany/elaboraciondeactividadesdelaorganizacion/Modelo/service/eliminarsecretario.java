/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irsecretario;

/**
 *
 * @author x
 */
public class eliminarsecretario implements eliminarinterface<dtosecretario>, irsecretario{

    @Override
    public String eliminardato(dtosecretario c) {
  rs.eliminar(c);
  return "Se elimino el secretario";
    }
    
}
