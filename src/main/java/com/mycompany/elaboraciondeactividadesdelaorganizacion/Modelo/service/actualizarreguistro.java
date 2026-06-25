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
public class actualizarreguistro implements actualizarinterface<dtoreguistro>, irreguistro{

    @Override
    public String actualizardato(dtoreguistro c) {
  rr.actualizar(c);
  return "Se actualizo el reguistro";
    }
    
}
