/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import java.util.List;

/**
 *
 * @author x
 */
public interface interfasecargadeventa {
    
    public void cargarcliente1(List<dtocliente> lista);
    public void cargarsecretario1(List<dtosecretario> lista);
    public void cargarfactura1(List<dtofactura> lista);
    public void cargarventa1(List<dtoventa> lista);
    public void cargarproducto1(List<dtoproducto> lista);
}
