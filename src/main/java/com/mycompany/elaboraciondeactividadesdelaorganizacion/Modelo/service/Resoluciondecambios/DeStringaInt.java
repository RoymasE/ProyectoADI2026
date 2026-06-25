/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios;

/**
 *
 * @author x
 */
public class DeStringaInt implements BaseDeTransformacion<String, Integer>{

    @Override
    public Integer Tranformacion(String base) {
   return Integer.parseInt(base.trim());
    }

  
    
}
