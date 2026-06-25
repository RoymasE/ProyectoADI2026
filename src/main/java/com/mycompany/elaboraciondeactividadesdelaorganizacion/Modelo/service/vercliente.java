/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rcliente;
import java.util.List;

/**
 *
 * @author x
 */
public class vercliente implements verinterface<List<dtocliente>>{

    @Override
    public List<dtocliente> Entrega() {
 rcliente b = new rcliente();
 return b.listar();
    
    }

    
    
}
