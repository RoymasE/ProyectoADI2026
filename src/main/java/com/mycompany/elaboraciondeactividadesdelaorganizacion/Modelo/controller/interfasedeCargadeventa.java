/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.crearfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.crearventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.verventa;

/**
 *
 * @author x
 */
public interface interfasedeCargadeventa {
    public verventa verventaobject = new verventa();
    public crearventa crearventaobjeto = new crearventa();
    public crearfactura crearfacturaobjeto = new crearfactura();
    
}
