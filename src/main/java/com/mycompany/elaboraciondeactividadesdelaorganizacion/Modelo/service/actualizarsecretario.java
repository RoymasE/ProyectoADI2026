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
public class actualizarsecretario implements actualizarinterface<dtosecretario>, irsecretario{

    @Override
    public String actualizardato(dtosecretario c) {
  rs.actualizar(c);
  return "Se actualizo el secretario";
    }
    
}
