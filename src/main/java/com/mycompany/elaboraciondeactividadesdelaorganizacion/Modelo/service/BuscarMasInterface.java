/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import java.util.List;

/**
 *
 * @author x
 */
public interface BuscarMasInterface {
    List<dtosecretario> buscarsecretario(int index, List<dtosecretario> lista);
    List<dtofactura> buscarcliente(int index, List<dtofactura> lista);
    List<dtocliente> buscarproducto(int index, List<dtocliente> lista);
   List<dtofactura> buscarfactura(int index, List<dtofactura> lista);
}
