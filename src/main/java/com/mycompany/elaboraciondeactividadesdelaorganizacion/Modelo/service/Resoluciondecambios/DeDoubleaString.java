/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios;

/**
 *
 * @author x
 */
public class DeDoubleaString implements BaseDeTransformacion<Double, String>{

    @Override
    public String Tranformacion(Double base) {
 return String.valueOf(base);
    }
    
}
