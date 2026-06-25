/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rproducto;
import java.util.List;

/**
 *
 * @author x
 */
public class verproducto implements verinterface<List<dtoproducto>>{

    @Override
    public List<dtoproducto> Entrega() {
  rproducto b = new rproducto();
  return b.listar();
    }
    
}
