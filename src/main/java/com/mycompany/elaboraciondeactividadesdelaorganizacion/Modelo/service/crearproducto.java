/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rproducto;

/**
 *
 * @author x
 */
public class crearproducto implements crearinterface<dtoproducto>{
rproducto rp = new rproducto();
        
    @Override
    public String regusitrar(dtoproducto c) {
 rp.creardato(c);
    return "creado";
    }
    
}
