/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.cliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rcliente;

/**
 *
 * @author x
 */
public class crearcliente implements crearinterface<dtocliente> {

    rcliente rc = new rcliente();

    @Override
    public String regusitrar(dtocliente c) {
        rc.creardato(c);
        return "Se guardo los datos";

    }

}
