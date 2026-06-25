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
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.clasesextras.clientemasdto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.ircliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.serviceinterfacemenor.irsecretario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x
 */
public class verventa extends clientemasdto implements verinterface<List<dtoventa>>, irfactura, ircliente, irproducto, irsecretario, BuscarMasInterface {

    @Override
    public List<dtoventa> Entrega() {
  rventa b = new rventa();
  return b.listar();
    }
    
    public List<dtosecretario> EntregarComplementoSecretario(){
    return rs.listar();
    }
    
    public List<dtofactura> EntregarComplementofactura(){
        rfactura rf = new rfactura();
        return rf.listar();
    }
    
    public List<dtocliente> EntregarComplementocliente(){
    return rc.listar();
    }
    
    
    public List<dtoproducto> EntregarComplementoproducto(){
    return rp.listar();
    }
    
    public List<dtosecretario> EntregarComplemento(){
    
    return rs.listar();
    }


    public List<dtosecretario> buscarsecretario(String index, List<dtosecretario> lista) {
        List<dtosecretario> nuevalista = new ArrayList<>();
   for(dtosecretario dtos : lista){
   if(dtos.getC().getIdSecretario().equalsIgnoreCase(index)){
   nuevalista.add(dtos);
   }
   
   }
    return nuevalista;
    }

 
    public List<dtocliente> buscarcliente(String index, List<dtocliente> lista) {
        List<dtocliente> nuevalista = new ArrayList<>();
        for(dtocliente dtos:lista){
        if(dtos.getC().getIdCliente().equalsIgnoreCase(index)){
        nuevalista.add(dtos);
        }
        }
        
        
        
   
    return nuevalista;
    
    }

   
    public List<dtoproducto> buscarproducto(String index, List<dtoproducto> lista) {
      List<dtoproducto> nuevalista = new ArrayList<>();
   for(dtoproducto dtos : lista){
   if(dtos.getC().getIdProducto().equalsIgnoreCase(index)){
   nuevalista.add(dtos);
   }
   
   }
    return nuevalista;
    
    }

    @Override
    public List<dtofactura> buscarfactura(int index, List<dtofactura> lista) {
      List<dtofactura> nuevalista = new ArrayList<>();
   for(dtofactura dtos : lista){
   if(dtos.getC().getIdFactura() == index){
   nuevalista.add(dtos);
   }
   
   }
    return nuevalista;
    
    
    }

    @Override
    public List<dtosecretario> buscarsecretario(int index, List<dtosecretario> lista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

    @Override
    public List<dtocliente> buscarproducto(int index, List<dtocliente> lista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<dtofactura> buscarcliente(int index, List<dtofactura> lista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
