/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rsecretario;
import java.util.List;

/**
 *
 * @author x
 */
public class versecretario implements verinterface<List<dtosecretario>>{

    @Override
    public List<dtosecretario> Entrega() {
  rsecretario b = new rsecretario();
    return b.listar();
    }
    
}
