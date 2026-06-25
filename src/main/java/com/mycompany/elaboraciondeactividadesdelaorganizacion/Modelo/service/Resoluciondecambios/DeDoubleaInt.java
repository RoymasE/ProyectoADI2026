/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios;

/**
 *
 * @author x
 */
public class DeDoubleaInt implements BaseDeTransformacion<Double, Integer>{

    @Override
    public Integer Tranformacion(Double base) {
 return (int) base.doubleValue();
    }

     
   

  
  

   
}
