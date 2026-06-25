/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.clasesextras.clientemasdto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.ircliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irsecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irventa;
import java.util.List;

/**
 *
 * @author x
 */
public class verfactura extends clientemasdto implements verinterface<List<dtofactura>>, irfactura, irventa, irproducto, ircliente, irsecretario {

    @Override
    public List<dtofactura> Entrega() {
        rfactura b = new rfactura();
        return b.listar();
    }

    public List<dtoventa> Entregaventa() {
  
        return rv.listar();
    }

    public List<dtosecretario> Entregasecretario() {
 
        return rs.listar();
    }

    public List<dtocliente> Entregacliente() {

        return rc.listar();
    }

    public List<dtoproducto> Entregaproducto() {

        return rp.listar();
    }

   

}
