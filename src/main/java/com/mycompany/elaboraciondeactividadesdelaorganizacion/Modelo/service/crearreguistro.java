/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoreguistro;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rreguistro;

/**
 *
 * @author x
 */
public class crearreguistro implements crearinterface<dtoreguistro>{
rreguistro rr =new rreguistro();
    @Override
    public String regusitrar(dtoreguistro c) {
 rr.creardato(c);
 return "Se creo un reguistro";
    }
    
}
