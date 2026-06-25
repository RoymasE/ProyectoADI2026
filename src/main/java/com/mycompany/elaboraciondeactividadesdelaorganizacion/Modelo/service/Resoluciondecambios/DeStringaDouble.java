/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios;

/**
 *
 * @author x
 */
public class DeStringaDouble implements BaseDeTransformacion<String, Double>{

    @Override
    public Double Tranformacion(String base) {
   return Double.parseDouble(base.trim());
    }
    
}
