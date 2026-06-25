/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoreguistro;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rreguistro;
import java.util.List;

/**
 *
 * @author x
 */
public class verreguistro implements verinterface<List<dtoreguistro>> {

    @Override
    public List<dtoreguistro> Entrega() {
        rreguistro b = new rreguistro();
        return b.listar();
    }

}
