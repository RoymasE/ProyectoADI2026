/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.actualizarproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.crearproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.eliminarproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.verproducto;

/**
 *
 * @author x
 */
public class clasedeaccionesdeproductos {
    private crearproducto crearproductoobject = new crearproducto();
    private actualizarproducto actualizarproductoobject = new actualizarproducto();
    private eliminarproducto eliminarproductoobject = new eliminarproducto();
    private verproducto verproductoobject = new verproducto();

    public crearproducto getCrearproductoobject() {
        return crearproductoobject;
    }

    public void setCrearproductoobject(crearproducto crearproductoobject) {
        this.crearproductoobject = crearproductoobject;
    }

    public actualizarproducto getActualizarproductoobject() {
        return actualizarproductoobject;
    }

    public void setActualizarproductoobject(actualizarproducto actualizarproductoobject) {
        this.actualizarproductoobject = actualizarproductoobject;
    }

    public eliminarproducto getEliminarproductoobject() {
        return eliminarproductoobject;
    }

    public void setEliminarproductoobject(eliminarproducto eliminarproductoobject) {
        this.eliminarproductoobject = eliminarproductoobject;
    }

    public verproducto getVerproductoobject() {
        return verproductoobject;
    }

    public void setVerproductoobject(verproducto verproductoobject) {
        this.verproductoobject = verproductoobject;
    }
    
    
    
}
