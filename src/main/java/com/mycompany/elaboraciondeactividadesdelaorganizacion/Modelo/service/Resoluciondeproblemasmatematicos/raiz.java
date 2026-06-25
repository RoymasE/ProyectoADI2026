/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondeproblemasmatematicos;

/**
 *
 * @author x
 */
public class raiz implements ClaseMatematicabase{

    @Override
    public double resolucionsimple(double base1, double base2) {
return Math.pow(base2, 1.0/base1);
    }
    
}
