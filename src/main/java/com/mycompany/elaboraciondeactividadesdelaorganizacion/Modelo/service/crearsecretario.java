/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rsecretario;

/**
 *
 * @author x
 */
public class crearsecretario implements crearinterface<dtosecretario> {
rsecretario rs = new rsecretario();

    @Override
    public String regusitrar(dtosecretario c) {
 rs.creardato(c);
    return "Se reguistro";
    }
    
}
