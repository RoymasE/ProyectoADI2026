/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.clasesextras;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;

/**
 *
 * @author x
 */
public class clientemasdto {
    protected dtocliente dtoc;

    public clientemasdto() {
    }
    protected dtoproducto dtop;
    
    static dtoproducto getDtop(){
    return new dtoproducto();
    }
    
}
